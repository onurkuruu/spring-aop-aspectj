package com.oonurkuru.spring.configuration;

import com.oonurkuru.spring.services.ProjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Onur Kuru on 18.7.2017.
 */

@Configuration
public class ProjectConfig {

    @Bean
    public ProjectService projectService() {
        return new ProjectService();
    }

}
