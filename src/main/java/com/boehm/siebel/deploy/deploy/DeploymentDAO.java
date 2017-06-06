package com.boehm.siebel.deploy.deploy;

import com.boehm.siebel.deploy.deploy.dto.AdmDTO;
import com.boehm.siebel.deploy.deploy.exception.DeploymentException;

import java.util.List;

public interface DeploymentDAO {
    List<AdmDTO> getAdmFiles(String folder) throws DeploymentException;
}
