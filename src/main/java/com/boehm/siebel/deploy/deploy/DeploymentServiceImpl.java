package com.boehm.siebel.deploy.deploy;

import com.siebel.data.*;
import com.siebel.eai.SiebelBusinessService;
import com.siebel.eai.SiebelBusinessServiceException;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeploymentServiceImpl extends SiebelConnectionService implements DeploymentService {
    String respository = null;

    public DeploymentServiceImpl() throws DeploymentException {
        super();

        try {
            this.login();
        } catch (SiebelException ex){
            ex.printStackTrace();
            throw new DeploymentException("Verbindung zu Siebel war nicht erfolgreich");
        }
    }

    @Override
    public void importSif(SifDTO f) throws DeploymentException{
        DocumentBuilderFactory factory = null;
        DocumentBuilder builder = null;
        Document doc = null;
        Element el = null;
        NamedNodeMap curAttributes = null;
        Attr curAttribute = null;
        Map<String, Map<String, String>> cumBcData;
        Map<String, String> curBcData;

        SiebelBusObject bo = null;
        SiebelService serv = null;
        SiebelPropertySet psIn = null;

        String nodeName = "";
        String parentNodeName = "";
        String curBcName = "";
        String curAttrName = "";
        String curAttrValue = "";

        try{
            serv = bean.getService("EAI Transaction Service");
            serv.invokeMethod("BeginTransaction", bean.newPropertySet(), bean.newPropertySet());

            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(f.getXml())));

            NodeList nl = doc.getElementsByTagName("*");

            for(int i = 0; i < nl.getLength(); i++){
                el = (Element) nl.item(i);
                nodeName = el.getNodeName();
                parentNodeName = el.getParentNode().getNodeName();

                if(nodeName == "REPOSITORY"){

                } else if(nodeName == "PROJECT"){

                } else {
                    if(parentNodeName.equals("PROJECT")){
                        bo = this.getBo(this.getBoName(nodeName));
                    }

                    curBcName = getBCName(nodeName);
                    curAttributes = el.getAttributes();
                    curBcData = new HashMap<>();

                    for (int x = 0; x < curAttributes.getLength(); x++) {
                        curAttribute = (Attr) curAttributes.item(x);
                        curAttrName = getFieldName(curAttribute.getName());
                        curAttrValue = curAttribute.getValue();

                        curBcData.put(curAttrName, curAttrValue);
                    }

                    writeDataToBc(bo, curBcName, curBcData);
                }
            }

            serv.invokeMethod("EndTransaction", bean.newPropertySet(), bean.newPropertySet());
        } catch (SiebelException ex){
            if(serv != null){
                psIn = bean.newPropertySet();
                psIn.setProperty("Is Abort", "True");

                try {
                    serv.invokeMethod("EndTransaction", psIn, bean.newPropertySet());
                } catch(Exception ex2){

                }
            }
        } catch (ParserConfigurationException ex){

        } catch (IOException ex){

        } catch (SAXException ex){

        } finally {
            if(bo != null){
                bo.release();
            }
        }
    }

    @Override
    public void activateWf(SifDTO sif) throws DeploymentException {

    }

    @Override
    public void activateTask(SifDTO sif) throws DeploymentException {

    }

    @Override
    public void importDocument() throws DeploymentException {

    }

    @Override
    public void importAdmFile(List<AdmDTO> adms) throws DeploymentException {
        for (AdmDTO curAdm : adms) {
            this.importAdmFile(curAdm);
        }
    }

    @Override
    public void importAdmFile(AdmDTO adm) throws DeploymentException {
        try {
            File file = new File(adm.getFile());

            if(file.exists()){
                this.invokeService("UDA Service", "Import File",
                        this.getSimplePropertySet(
                                new String[]{"Import File Path", "Session Id"},
                                new String[]{file.getParent(), file.getName()})
                );
            } else {
                throw new DeploymentException("ADM-Datei konnte auf dem Deployment-Server nicht gefunden werden");
            }
        } catch (SiebelException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportAdmFile(List<AdmDTO> adms) throws DeploymentException {
        for (AdmDTO curAdm : adms) {
            this.exportAdmFile(curAdm);
        }
    }

    @Override
    public void exportAdmFile(AdmDTO adm) throws DeploymentException {
        try {
            SiebelService serv = this.bean.getService("");
        } catch (SiebelException e) {
            e.printStackTrace();
        }
    }

    private String getBCName(String xmlName){
        return "Repository" + capitalizeName(xmlName);
    }

    private String capitalizeName(String xmlName){
        String[] values = xmlName.split("_");
        String result = "";

        for (int i = 0; i < values.length;  i++) {
            result = result + new String(values[i].charAt(0)+"") + values[i].substring(1).toLowerCase();

            if(i < values.length - 1){
                result = result + " ";
            }
        }

        return result.substring(0, result.length() - 2);
    }

    private String getFieldName(String xmlName){
        return capitalizeName(xmlName);
    }

    private SiebelBusObject getBo(String bcName) throws SiebelException{
        return bean.getBusObject(bcName);
    }

    private String getBoName(String boName){
        return "";
    }

    private void writeDataToBc(SiebelBusObject bo, String bcName, Map<String, String> curBcData) throws SiebelException{
        SiebelBusComp bc = null;

        try {
            bc = bo.getBusComp(bcName);

            bc.clearToQuery();
            bc.setViewMode(3);
            bc.invokeMethod("SetAdminMode", new String[]{"TRUE"});
            bc.newRecord(1);

            for(Map.Entry<String, String> entry : curBcData.entrySet()){
                bc.activateField(entry.getKey());
                bc.setFieldValue(entry.getKey(), entry.getValue());
            }

            bc.writeRecord();
        } catch(SiebelException ex){
            throw ex;
        }
    }
}
