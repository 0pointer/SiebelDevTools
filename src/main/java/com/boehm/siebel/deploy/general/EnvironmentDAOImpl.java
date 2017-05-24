package com.boehm.siebel.deploy.general;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentDAOImpl implements EnvironmentDAO{

    @Override
    public List<EnvironmentDTO> getEnvironments() {
        ArrayList<EnvironmentDTO> lst = new ArrayList<>();
        lst.add(new EnvironmentDTO(1, "X-Umgebung", "X"));
        lst.add(new EnvironmentDTO(2, "P-Umgebung", "P"));
        return lst;
    }
}
