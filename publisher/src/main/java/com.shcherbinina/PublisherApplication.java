package com.shcherbinina;

import com.shcherbinina.config.BeanConfig;
import com.shcherbinina.sending.MessageSender;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan(basePackages={"com.shcherbinina"})
public class PublisherApplication {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);

        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(5);

        scheduledService.scheduleAtFixedRate(() -> messageSender.send(), 5L, 15L, TimeUnit.SECONDS);
        scheduledService.scheduleAtFixedRate(() -> messageSender.send(), 5L, 15L, TimeUnit.SECONDS);
        scheduledService.scheduleAtFixedRate(() -> messageSender.send(), 5L, 15L, TimeUnit.SECONDS);
        scheduledService.scheduleAtFixedRate(() -> messageSender.send(), 5L, 15L, TimeUnit.SECONDS);
        scheduledService.scheduleAtFixedRate(() -> messageSender.send(), 5L, 15L, TimeUnit.SECONDS);
    }
}
