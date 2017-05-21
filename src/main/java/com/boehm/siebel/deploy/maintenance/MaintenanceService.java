package com.boehm.siebel.deploy.maintenance;

import org.springframework.stereotype.Service;

public interface MaintenanceService {
    public void executeService(SiebelBSServiceCallDTO call) throws MaintenanceException;
}
