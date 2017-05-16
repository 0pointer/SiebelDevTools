package com.boehm.siebel.deploy.tools;

/**
 * Created by boechr on 16.05.2017.
 */
public class ConverterRequestDTO {
    public enum ConvertType {TAB_TO_JIRA};

    private ConvertType convertType;
    private String request;
    private boolean headerAvailable;

    public boolean isHeaderAvailable() {
        return headerAvailable;
    }

    public void setHeaderAvailable(boolean headerAvailable) {
        this.headerAvailable = headerAvailable;
    }

    public ConvertType getConvertType() {
        return convertType;
    }

    public void setConvertType(ConvertType convertType) {
        this.convertType = convertType;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
