package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.general.EnvironmentDAO;
import com.boehm.siebel.deploy.general.EnvironmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"selectedEnvironment", "availableEnvironments", "login"})
public class ControllerTemplate {
    @Autowired
    private EnvironmentDAO environments;

    @ModelAttribute("availableEnvironments")
    public List<EnvironmentDTO> getEnvironments(){
        return environments.getEnvironments();
    }
}