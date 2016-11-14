package ru.schoolarlife.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by victor on 14.11.16.
 */
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "ru.schoolarlife")
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages_en_US");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
