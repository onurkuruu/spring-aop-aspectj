package com.oonurkuru.spring.configuration;

import com.oonurkuru.spring.services.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Onur Kuru on 18.7.2017.
 */

@Configuration
public class PersonConfig {

    @Bean
    public PersonService personService() {
        return new PersonService();
    }
}
