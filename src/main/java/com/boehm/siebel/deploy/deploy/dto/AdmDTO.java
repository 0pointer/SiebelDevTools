package com.boehm.siebel.deploy.deploy.dto;

/**
 * Created by boechr on 11.05.2017.
 */
public class AdmDTO {
    private String file = "";

    public AdmDTO(){

    }

    public AdmDTO(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
