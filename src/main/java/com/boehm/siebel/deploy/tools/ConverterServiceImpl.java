package com.boehm.siebel.deploy.tools;

import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

    @Override
    public ConverterResultDTO convertTabToJira(ConverterRequestDTO tab) {
        String result = tab.getRequest();
        String[] tempResult;

        result = result.replaceAll("\t", "|");
        result = result.replaceAll("\n", "|\n|");
        result = result.replaceAll("^", "|");
        result = result.replaceAll("$", "|");

        if(tab.isHeaderAvailable()){
            tempResult = result.split("\n");

            for(int i = 0; i < tempResult.length; i++){
                if(i == 0){
                    result = tempResult[i].replaceAll("\\|", "||") + "\n";
                } else {
                    result = result + tempResult[i] + "\n";
                }
            }
        }

        return new ConverterResultDTO(result);
    }

    @Override
    public ConverterResultDTO convertIdToSiebelQL(ConverterRequestDTO tab) {
        String result = "";
        String[] tempResult;

        tempResult = tab.getRequest().split("\n");

        for(int i = 0; i < tempResult.length; i++){
            result = result + "[Id]='" + tempResult[i] + "' OR ";
        }

        result = result.substring(0, result.length() - 4);

        return new ConverterResultDTO(result);
    }
}
