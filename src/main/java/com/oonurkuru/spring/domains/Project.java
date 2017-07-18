package com.oonurkuru.spring.domains;

/**
 * Created by Onur Kuru on 18.7.2017.
 */
public class Project {

    private String name;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
