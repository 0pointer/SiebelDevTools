package com.boehm.siebel.deploy.controller;

import com.boehm.siebel.deploy.tools.dto.ConverterRequestDTO;
import com.boehm.siebel.deploy.tools.dto.ConverterResultDTO;
import com.boehm.siebel.deploy.tools.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tools")
public class ToolsController extends ControllerTemplate {
    @Autowired
    private ConverterService converter;

    @GetMapping("/converter")
    public String converter(ModelMap model) {
        model.addAttribute("conversionTypes", ConverterRequestDTO.ConvertType.values());
        return "converter";
    }

    @RequestMapping(value = "/api/convert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ConverterResultDTO convert(@RequestBody ConverterRequestDTO input) {
        if(input.getConvertType() == ConverterRequestDTO.ConvertType.TAB_TO_JIRA){
            return converter.convertTabToJira(input);
        } else if(input.getConvertType() == ConverterRequestDTO.ConvertType.ROWID_TO_SIEBELQL){
            return converter.convertIdToSiebelQL(input);
        } else if(input.getConvertType() == ConverterRequestDTO.ConvertType.OR_CONNECTED){
            return converter.convertViaOr(input);
        } else if(input.getConvertType() == ConverterRequestDTO.ConvertType.SIEBPS_TO_STRUCTURE) {
            return converter.convertPsToStructure(input);
        } else if(input.getConvertType() == ConverterRequestDTO.ConvertType.COMMA_CONNECTED) {
            return converter.convertViaComma(input);
        } else {
            return new ConverterResultDTO("");
        }
    }

    @GetMapping("/linklist")
    public String linklist(ModelMap model) {
        model.addAttribute("name", "XXX");
        return "converter";
    }
}
