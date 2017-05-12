package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.deploy.AdmDTO;
import com.boehm.siebel.deploy.deploy.DeploymentDAO;
import com.boehm.siebel.deploy.deploy.DeploymentException;
import com.boehm.siebel.deploy.deploy.DeploymentService;
import com.boehm.siebel.deploy.dto.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"environment", "user"})
@RequestMapping("/svn")
public class SVNController {
    @Autowired
    DeploymentDAO deployDAO;
    @Autowired
    DeploymentService deployService;

    @GetMapping("/")
    public String merge(@RequestParam(value="name", required=false, defaultValue="World") String name, ModelMap model) {
        model.addAttribute("name", "XXX");
        return "svnmerge";
    }

    @PostMapping("/merge")
    public String greeting(@ModelAttribute("thread") ThreadDTO thread) {
        return "svnmergeresult";
    }

    @GetMapping("importAdm")
    public String importAdm(){
        try {
            List<AdmDTO> lst = deployDAO.getAdmFiles("\\\\NCVSAPPx01\\TEMP\\Import\\ADM\\");
            deployService.importAdmFile(lst);
        } catch (DeploymentException e) {
            e.printStackTrace();
        }

        return "admimported";
    }
}