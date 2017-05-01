package com.boehm.siebel.deploy.svn;

/**
 * Created by Christoph on 01.05.2017.
 */
public class ThreadDTO {
    private String version;

    public ThreadDTO(){

    }

    public ThreadDTO(String version) {
        this.version = version;
    }

    public String getVersion() {

        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
