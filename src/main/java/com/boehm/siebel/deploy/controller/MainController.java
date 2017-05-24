package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.deploy.DeploymentDAO;
import com.boehm.siebel.deploy.deploy.DeploymentException;
import com.boehm.siebel.deploy.deploy.DeploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController extends ControllerTemplate {
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String start(){
        return "start";
    }
}