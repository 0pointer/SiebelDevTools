package com.boehm.siebel.deploy.maintenance;

import java.util.List;

public class SiebelBSServiceCallDTO {
    private String bs;
    private String method;

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

    public List<SiebelBSParameterDTO> getParameter() {
        return parameter;
    }

    public void setParameter(List<SiebelBSParameterDTO> parameter) {
        this.parameter = parameter;
    }

    private List<SiebelBSParameterDTO> parameter;
}
