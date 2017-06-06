package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.general.EnvironmentConfigurationDTO;
import com.boehm.siebel.deploy.general.EnvironmentDAO;
import com.boehm.siebel.deploy.general.EnvironmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"environmentConfiguration", "login"})
public class ControllerTemplate {
    @Autowired
    protected EnvironmentDAO environmentDao;

    @ModelAttribute("environmentConfiguration")
    public EnvironmentConfigurationDTO getEnvironmentService(){
        EnvironmentConfigurationDTO dto = new EnvironmentConfigurationDTO();
        dto.setEnvironments(environmentDao.getEnvironments());
        return dto;
    }
}