package com.boehm.siebel.deploy.maintenance;

import com.boehm.siebel.deploy.generated.SiebelScriptConfigurations;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Component
public class SiebelBSDAOImpl implements SiebelBSDAO {
    private String configurationFileName = "configuration/SiebelBusinessServices.xml";
    private URL confFile = getClass().getClassLoader().getResource(configurationFileName);

    @Override
    public List<SiebelBSServiceCallDTO> getAvailableServices() throws MaintenanceException {
        ArrayList<SiebelBSServiceCallDTO> lst = new ArrayList<>();
        try {
            JAXBContext jc = JAXBContext.newInstance(SiebelScriptConfigurations.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            SiebelScriptConfigurations db = (SiebelScriptConfigurations) unmarshaller.unmarshal(confFile);
            for (com.boehm.siebel.deploy.generated.SiebelScriptConfigurations.SiebelBusinessServices.SiebelBusinessService bs : db.getSiebelBusinessServices().getSiebelBusinessService()) {
                lst.add(new SiebelBSServiceCallDTO(bs.getGuid(), bs.getName(), bs.getBusinessServiceName(), bs.getMethodName(), bs.getDescription()));
            }
        } catch (Exception ex){
            throw new MaintenanceException(ex.getMessage());
        }

        return lst;
    }

    @Override
    public List<String> getServiceParameter(String guid) throws MaintenanceException {
        ArrayList<String> params = new ArrayList<>();
        try {
            JAXBContext jc = JAXBContext.newInstance(SiebelScriptConfigurations.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            SiebelScriptConfigurations db = (SiebelScriptConfigurations) unmarshaller.unmarshal(confFile);

            for (com.boehm.siebel.deploy.generated.SiebelScriptConfigurations.SiebelBusinessServices.SiebelBusinessService bs : db.getSiebelBusinessServices().getSiebelBusinessService()) {
                if(bs.getGuid().equals(guid)){
                    for (SiebelScriptConfigurations.SiebelBusinessServices.SiebelBusinessService.Parameters.Parameter param: bs.getParameters().getParameter()){
                        params.add(param.getDisplayName());
                    }
                }
            }
        } catch (Exception ex){
            throw new MaintenanceException(ex.getMessage());
        }

        return params;
    }
}
