package com.boehm.siebel.deploy.maintenance;

import java.util.List;

public class SiebelBSServiceCallDTO {
    private String guid;
    private String name;
    private String bs;
    private String method;
    private String description;

    public SiebelBSServiceCallDTO(String guid, String name, String bs, String method, String description) {
        this.guid = guid;
        this.name = name;
        this.bs = bs;
        this.method = method;
        this.description = description;
    }

    public String getGuid() {

        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
