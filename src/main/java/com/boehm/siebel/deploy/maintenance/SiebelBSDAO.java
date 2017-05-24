package com.boehm.siebel.deploy.maintenance;

import java.util.List;

public interface SiebelBSDAO {
    public List<SiebelBSServiceCallDTO> getAvailableServices() throws MaintenanceException;
    public List<String> getServiceParameter(String uid) throws MaintenanceException;
}
