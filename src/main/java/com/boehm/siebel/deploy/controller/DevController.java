package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.dao.SifDAO;
import com.boehm.siebel.deploy.deploy.SifDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dev")
public class DevController {
    @Autowired
    SifDAO sifDao;

    @Autowired
    DevController controller;

    @GetMapping("/search")
    public String search(ModelMap model) {
        return "codesearch";
    }

    @RequestMapping(value = "/search/{query}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<SifDTO> searchSif(@PathVariable String query){
        return sifDao.getSifFromStorageViaXmlSearch(query);
    }
}