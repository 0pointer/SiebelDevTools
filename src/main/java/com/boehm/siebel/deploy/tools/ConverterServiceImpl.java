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
}
