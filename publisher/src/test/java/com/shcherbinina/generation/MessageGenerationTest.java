package com.shcherbinina.generation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessageGenerationTest {

    @Test
    void generateMessageTest() {
        Message message = MessageGeneration.generateMessage();
        Message message2 = MessageGeneration.generateMessage();

        assertNotNull(message);
        assertNotNull(message2);

        assertTrue(message.getId() != message2.getId());
    }
}