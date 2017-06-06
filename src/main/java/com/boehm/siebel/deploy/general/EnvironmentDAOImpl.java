package com.boehm.siebel.deploy.general;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentDAOImpl implements EnvironmentDAO{
    ArrayList<EnvironmentDTO> lst = new ArrayList<>();

    public EnvironmentDAOImpl() {
        lst.add(new EnvironmentDTO("1", "X-Umgebung", "X"));
        lst.add(new EnvironmentDTO("2", "P-Umgebung", "P"));
         }

    @Override
    public List<EnvironmentDTO> getEnvironments() {
        return lst;
    }

    @Override
    public EnvironmentDTO getEnvironmentById(String id) {
        EnvironmentDTO env = null;

        for(EnvironmentDTO curEnv : lst){
            if(curEnv.getId().equals(id)){
                env = curEnv;
            }
        }

        return env;
    }
}
