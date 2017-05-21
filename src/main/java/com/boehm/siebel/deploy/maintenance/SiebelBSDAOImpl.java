package com.boehm.siebel.deploy.maintenance;

import com.boehm.siebel.deploy.generated.DataBase;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Component
public class SiebelBSDAOImpl implements SiebelBSDAO {

    @Override
    public List<String> getAvailableMethods() throws MaintenanceException {
        ArrayList<String> lst = new ArrayList<>();
        try {
            JAXBContext jc = JAXBContext.newInstance(DataBase.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            DataBase db = (DataBase) unmarshaller.unmarshal(new File("WEB-INF/configuration/SiebelBusinessServices.xml"));
            for (com.boehm.siebel.deploy.generated.DataBase.SiebelBusinessServices.SiebelBusinessService bs : db.getSiebelBusinessServices().getSiebelBusinessService()) {
                lst.add(bs.getName());
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
            JAXBContext jc = JAXBContext.newInstance(DataBase.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            DataBase db = (DataBase) unmarshaller.unmarshal(new File("WEB-INF/configuration/SiebelBusinessServices.xml"));

            for (com.boehm.siebel.deploy.generated.DataBase.SiebelBusinessServices.SiebelBusinessService bs : db.getSiebelBusinessServices().getSiebelBusinessService()) {
                if(bs.getGuid().equals(guid)){
                    for (DataBase.SiebelBusinessServices.SiebelBusinessService.Parameters.Parameter param: bs.getParameters().getParameter()){
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
