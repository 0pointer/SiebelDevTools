package com.boehm.siebel.deploy.development;

/**
 * Created by boechr on 22.05.2017.
 */
public class SifDTO {
    public enum SifType {
        WORKFLOW ("Workflow"),
        TASK ("Task"),
        BUSINESS_SERVICE ("Business Service");

        private final String name;

        private SifType(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            // (otherName == null) check is not needed because name.equals(null) returns false
            return name.equals(otherName);
        }

        public String toString() {
            return this.name;
        }
    }

    private String repository;
    private String name;
    private SifType sifType;

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SifType getSifType() {
        return sifType;
    }

    public void setSifType(SifType sifType) {
        this.sifType = sifType;
    }
}
