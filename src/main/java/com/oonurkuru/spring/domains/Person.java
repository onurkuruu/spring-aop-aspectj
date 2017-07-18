package com.oonurkuru.spring.domains;

import java.util.List;

/**
 * Created by Onur Kuru on 18.7.2017.
 */

public class Person {

    private String name;
    private List<Project> projectList;

    public Person() {
    }

    public Person(String name, List<Project> projectList) {
        this.name = name;
        this.projectList = projectList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
