package com.boehm.siebel.deploy.maintenance;

import java.util.List;

public interface MaintenanceService {
    public List<String> getAvailableMethods() throws MaintenanceException;
    public SiebelServiceCallDTO getService(String uid) throws MaintenanceException;
    public List<SiebelServiceCallDTO> getService() throws MaintenanceException;
    public void executeService(SiebelServiceCallDTO call) throws MaintenanceException;
}
