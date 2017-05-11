package com.boehm.siebel.deploy.deploy;

/**
 * Created by boechr on 02.05.2017.
 */
public class SifDTO {
    private String project;
    private String type;
    private String name;
    private String xml;

    public SifDTO(String project, String type, String name, String xml) {
        this.project = project;
        this.type = type;
        this.name = name;
        this.xml = xml;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
