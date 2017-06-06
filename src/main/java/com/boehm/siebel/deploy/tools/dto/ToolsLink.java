package com.boehm.siebel.deploy.tools.dto;

public class ToolsLink {
    private int id;
    private String system;
    private String name;
    private String url;

    public ToolsLink() {
    }

    public ToolsLink(int id, String system, String name, String url) {
        this.id = id;
        this.system = system;
        this.name = name;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
