package com.boehm.siebel.deploy.maintenance;

import java.util.List;

public interface SiebelBSDAO {
    public List<String> getAvailableMethods() throws MaintenanceException;
    public List<String> getServiceParameter(String uid) throws MaintenanceException;
}
