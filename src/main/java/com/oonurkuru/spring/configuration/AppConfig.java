package com.oonurkuru.spring.configuration;

import com.oonurkuru.spring.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * Created by Onur Kuru on 18.7.2017.
 */

@Configuration
@Import({PersonConfig.class, ProjectConfig.class})
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
