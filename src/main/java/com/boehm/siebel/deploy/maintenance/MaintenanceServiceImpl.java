package com.boehm.siebel.deploy.maintenance;

import com.boehm.siebel.deploy.siebel.SiebelBSSimulator;
import com.boehm.siebel.deploy.siebel.SiebelTaskException;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImpl implements  MaintenanceService {
    @Override public void executeService(SiebelBSServiceCallDTO call) throws MaintenanceException {
        SiebelBSSimulator bs = new SiebelBSSimulator(call);

        try {
            bs.execute();
        } catch (SiebelTaskException ex){
            throw new MaintenanceException(ex.getMessage());
        }
    }
}
