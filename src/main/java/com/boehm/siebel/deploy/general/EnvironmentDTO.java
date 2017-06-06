package com.boehm.siebel.deploy.general;

/**
 * Created by boechr on 22.05.2017.
 */
public class EnvironmentDTO {
    private String id;
    private String name;
    private String abbreviation;

    public EnvironmentDTO() {
    }

    public EnvironmentDTO(String id, String name, String abbreviation) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
