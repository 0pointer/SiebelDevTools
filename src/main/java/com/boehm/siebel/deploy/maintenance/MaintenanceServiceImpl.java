package com.boehm.siebel.deploy.maintenance;

import java.util.List;

public class MaintenanceServiceImpl implements MaintenanceService {
    @Override
    public List<String> getAvailableMethods() throws MaintenanceException{
        return null;
    }

    @Override
    public SiebelServiceCallDTO getService(String uid) throws MaintenanceException{
        return null;
    }

    @Override
    public List<SiebelServiceCallDTO> getService() throws MaintenanceException{
        return null;
    }

    @Override
    public void executeService(SiebelServiceCallDTO call) throws MaintenanceException {

    }
}
