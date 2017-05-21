package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.maintenance.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"environment", "user"})
@RequestMapping("/maintenance")
public class MaintainanceController {
    @Autowired
    private SiebelBSDAO bsDao;
    @Autowired
    private MaintenanceService mainService;

    @GetMapping("/siebservice")
    public String siebservice(String name, ModelMap model) {
        try {
            model.addAttribute("siebelServices", bsDao.getAvailableMethods());
        }catch (MaintenanceException ex){

        }

        return "siebservice";
    }

    @RequestMapping(value = "/api/paramsiebservice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getParamSiebService(@RequestBody String uid) {
        List<String> params = null;

        try {
            params = bsDao.getServiceParameter(uid);
        } catch (MaintenanceException ex){

        }

        return params;
    }

    @RequestMapping(value = "/api/executesiebservice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void executeSiebService(@RequestBody SiebelBSServiceCallDTO input) {
        try {
            mainService.executeService(input);
        } catch (MaintenanceException ex){

        }
    }

    @RequestMapping(value = "/api/executesiebservice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void executeSiebServices(@RequestBody List<SiebelBSServiceCallDTO> input) {
        for(SiebelBSServiceCallDTO call : input){
            this.executeSiebService(call);
        }
    }
}