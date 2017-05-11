package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.dto.ThreadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/svn")
public class SVNController {
    @Autowired
    SVNController controller;

    @GetMapping("/")
    public String merge(@RequestParam(value="name", required=false, defaultValue="World") String name, ModelMap model) {
        model.addAttribute("name", "XXX");
        return "svnmerge";
    }

    @PostMapping("/merge")
    public String greeting(@ModelAttribute("thread") ThreadDTO thread) {
        return "svnmergeresult";
    }
}