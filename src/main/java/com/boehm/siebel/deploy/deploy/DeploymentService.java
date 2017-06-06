package com.boehm.siebel.deploy.deploy;

import com.boehm.siebel.deploy.deploy.dto.AdmDTO;
import com.boehm.siebel.deploy.deploy.dto.SifDTO;
import com.boehm.siebel.deploy.deploy.exception.DeploymentException;

import java.util.List;

public interface DeploymentService {
    // SIF-Tools
    public void importSif(SifDTO sif) throws DeploymentException;
    public void activateWf(SifDTO sif) throws DeploymentException;
    public void activateTask(SifDTO sif) throws DeploymentException;

    // Document-Tools
    public void importDocument() throws DeploymentException;

    // ADM-Tools
    public void importAdmFile(AdmDTO adm) throws DeploymentException;
    public void exportAdmFile(AdmDTO adm) throws DeploymentException;
    public void importAdmFile(List<AdmDTO> adms) throws DeploymentException;
    public void exportAdmFile(List<AdmDTO> adms) throws DeploymentException;
}
