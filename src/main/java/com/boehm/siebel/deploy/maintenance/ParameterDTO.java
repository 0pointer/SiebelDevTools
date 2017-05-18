package com.boehm.siebel.deploy.maintenance;

public class ParameterDTO {
    private String key;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
