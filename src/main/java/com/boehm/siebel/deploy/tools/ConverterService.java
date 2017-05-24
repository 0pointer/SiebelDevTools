package com.boehm.siebel.deploy.tools;

import org.springframework.stereotype.Service;

public interface ConverterService {
    public ConverterResultDTO convertTabToJira(ConverterRequestDTO tab);
    public ConverterResultDTO convertIdToSiebelQL(ConverterRequestDTO tab);
    public  ConverterResultDTO convertViaOr(ConverterRequestDTO input);
}
