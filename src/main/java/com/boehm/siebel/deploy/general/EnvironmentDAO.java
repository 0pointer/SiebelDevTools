package com.boehm.siebel.deploy.general;

import java.util.List;

public interface EnvironmentDAO {
    public List<EnvironmentDTO> getEnvironments();
    public EnvironmentDTO getEnvironmentById(String id);
}
