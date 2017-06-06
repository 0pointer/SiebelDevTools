package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.general.EnvironmentConfigurationDTO;
import com.boehm.siebel.deploy.general.EnvironmentDAO;
import com.boehm.siebel.deploy.general.EnvironmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;

@Controller
public class MainController extends ControllerTemplate {
    @Autowired
    EnvironmentDAO dao;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String start(){
        return "start";
    }

    @RequestMapping(value = "/api/changeEnv", method = RequestMethod.POST)
    public @ResponseBody void changeEnv(@RequestBody String env, HttpServletRequest request) {
        EnvironmentConfigurationDTO conf = (EnvironmentConfigurationDTO)request.getSession().getAttribute("environmentConfiguration");
        conf.setCurEnvironment(dao.getEnvironmentById(env));
    }
}