package com.boehm.siebel.deploy.tools;

import com.boehm.siebel.deploy.tools.dto.ConverterRequestDTO;
import com.boehm.siebel.deploy.tools.dto.ConverterResultDTO;

public interface ConverterService {
    public ConverterResultDTO convertTabToJira(ConverterRequestDTO tab);
    public ConverterResultDTO convertIdToSiebelQL(ConverterRequestDTO tab);
    public  ConverterResultDTO convertViaOr(ConverterRequestDTO input);
    public  ConverterResultDTO convertViaComma(ConverterRequestDTO input);
    public  ConverterResultDTO convertPsToStructure(ConverterRequestDTO input);
    public  ConverterResultDTO convertViaSign(ConverterRequestDTO input, String seperator, String prefix, String suffix, String connection, boolean lineBreak);
}
