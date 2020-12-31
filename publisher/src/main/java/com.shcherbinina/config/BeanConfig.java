package com.shcherbinina.config;

import com.shcherbinina.sending.MessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
@ComponentScan
public class BeanConfig {

    @Bean
    public MessageSender messageSender() {
        return new MessageSender();
    }
}
