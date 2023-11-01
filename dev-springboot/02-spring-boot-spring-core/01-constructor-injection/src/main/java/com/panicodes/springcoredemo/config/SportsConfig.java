package com.panicodes.springcoredemo.config;

import com.panicodes.springcoredemo.common.Coach;
import com.panicodes.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean("aquatic")
    public Coach mySwimCoach(){//beanID defaults to the method name--here swimCoach
        return new SwimCoach();
    }
}
