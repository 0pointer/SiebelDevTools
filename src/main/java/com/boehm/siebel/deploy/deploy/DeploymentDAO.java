package com.boehm.siebel.deploy.deploy;

import java.util.List;

public interface DeploymentDAO {
    List<AdmDTO> getAdmFiles(String folder) throws DeploymentException;
}
