package com.zarek.crm.configuration;

import com.zarek.crm.filter.ResourcesFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class ResourcesFilterConfig {

    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ResourcesFilter());
        registration.addUrlPatterns("/workbench/*");
        registration.addUrlPatterns("/admin/*");
        registration.addUrlPatterns("/settings/");
        registration.setName("ResourcesFilter");
        registration.setOrder(1);

        return registration;
    }
}
