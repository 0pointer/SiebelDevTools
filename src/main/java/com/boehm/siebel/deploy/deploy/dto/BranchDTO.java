package com.boehm.siebel.deploy.deploy.dto;

/**
 * Created by boechr on 01.06.2017.
 */
public class BranchDTO {
    private String branchUrl;
    private String branchUser;
    private String branchPassword;
    private String startRevision;

    public BranchDTO(String branchUrl) {
        this.branchUrl = branchUrl;
    }

    public String getBranchUrl() {
        return branchUrl;
    }

    public void setBranchUrl(String branchUrl) {
        this.branchUrl = branchUrl;
    }
}
