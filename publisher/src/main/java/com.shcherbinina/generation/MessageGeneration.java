package com.shcherbinina.generation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageGeneration {
    private static final Logger logger = LoggerFactory.getLogger(
            MessageGeneration.class);
    private static AtomicLong messageId = new AtomicLong(0);
    private enum Action {
        PURCHASE,
        SUBSCRIPTION;

        public static Action getRandomAction() {
            return values()[random.nextInt(values().length)];
        }
    }

    @Autowired
    private static Random random = new Random();

    public static Message generateMessage() {
        Message message = Message.builder()
                .id(messageId.incrementAndGet())
                .msisdn(Math.abs(random.nextLong()))
                .action(Action.getRandomAction().toString())
                .timestamp(System.currentTimeMillis() / 1000L)
                .build();
        logger.error("MessageGeneration: new message was generated");
        return message;
    }
}
