package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.maintenance.SiebelServiceCallDTO;
import com.boehm.siebel.deploy.tools.ConverterRequestDTO;
import com.boehm.siebel.deploy.tools.ConverterResultDTO;
import com.boehm.siebel.deploy.tools.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"environment", "user"})
@RequestMapping("/maintenance")
public class MaintainanceController {
    @Autowired
    private ConverterService converter;

    @GetMapping("/siebservice")
    public String converter(String name, ModelMap model) {
        return "test";
    }

    @RequestMapping(value = "/api/executeService", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void convert(@RequestBody SiebelServiceCallDTO input) {

    }
}