package com.oonurkuru.spring;

import com.oonurkuru.spring.configuration.AppConfig;
import com.oonurkuru.spring.domains.Person;
import com.oonurkuru.spring.domains.Project;
import com.oonurkuru.spring.services.PersonService;
import com.oonurkuru.spring.services.ProjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Onur Kuru on 18.7.2017.
 */
public class RunExample {

    public static void main(String args[]) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        PersonService personService = (PersonService) applicationContext.getBean("personService");
        ProjectService projectService = (ProjectService) applicationContext.getBean("projectService");

        Person person = new Person("Onur", Arrays.asList(new Project("Spring"), new Project("JPA")));

        personService.savePerson(person);
//        personService.updatePerson(null);

    }
}
