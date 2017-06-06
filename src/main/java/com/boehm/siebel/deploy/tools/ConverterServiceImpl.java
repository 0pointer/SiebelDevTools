package com.boehm.siebel.deploy.tools;

import com.boehm.siebel.deploy.tools.dto.ConverterRequestDTO;
import com.boehm.siebel.deploy.tools.dto.ConverterResultDTO;
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
    public ConverterResultDTO convertIdToSiebelQL(ConverterRequestDTO input) {
        return convertViaSign(input, "\n", "[Id]='", "'", " OR ", false);
    }

    @Override
    public ConverterResultDTO convertViaOr(ConverterRequestDTO input) {
        return convertViaSign(input, "\n", "'", "'", " OR ", false);
    }

    @Override
    public ConverterResultDTO convertViaComma(ConverterRequestDTO input) {
        return convertViaSign(input, "\n", "'", "'", ",", true);
    }

    @Override
    public ConverterResultDTO convertViaSign(ConverterRequestDTO input, String seperator, String prefix, String suffix, String connection, boolean lineBreak) {
        String result = "";
        String curItem = "";
        String[] items;

        items = input.getRequest().split(seperator);
        int itemLength = items.length;

        for(int i = 0; i < itemLength; i++){
            curItem = items[i];
            result = result + prefix + curItem + suffix;

            if((i+1) < itemLength){
                result = result + connection;

                if(lineBreak){
                    result = result + "\n";
                }
            }
        }

        return new ConverterResultDTO(result);
    }

    @Override
    public ConverterResultDTO convertPsToStructure(ConverterRequestDTO input) {
        String result = "";
        /*+String str = input.getRequest();
        String elRest = str.substring(1, str.length());
        String elValue
        int elNextLength = 0;
        int elLength = 0;

        do {
            elLength = str.indexOf("*");
            elNextLength = new Integer(elRest.substring(0, elLength));
            elValue
        } while (elPosition < el.length());
        */

        return new ConverterResultDTO(result);
    }
}
