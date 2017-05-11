package com.boehm.siebel.deploy.dao;

import javax.persistence.*;

@Entity
@Table(name="sifs")
public class SifEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "project")
    @Basic(optional = false)
    private String project;

    @Column(name = "type")
    @Basic(optional = false)
    private String type;

    @Column(name = "name")
    @Basic(optional = false)
    private String name;

    @Column(name = "xml")
    @Basic(optional = false)
    private String xml;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
