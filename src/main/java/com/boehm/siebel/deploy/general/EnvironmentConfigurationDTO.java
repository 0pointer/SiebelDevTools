package com.boehm.siebel.deploy.general;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentConfigurationDTO {
    private List<EnvironmentDTO> environments;
    private EnvironmentDTO curEnvironment;

    public List<EnvironmentDTO> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<EnvironmentDTO> environments) {
        this.environments = environments;
    }

    public EnvironmentDTO getCurEnvironment() {
        return curEnvironment;
    }

    public void setCurEnvironment(EnvironmentDTO curEnvironment) {
        this.curEnvironment = curEnvironment;
    }
}
