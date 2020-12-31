package com.shcherbinina.sending;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessageSenderTest {
    @InjectMocks
    private MessageSender messageSender;
    private WebResource target;
    private String actionJson = "{\"id\":\"1\",\"msisdn\":\"123456789\",\"action\":\"PURCHASE\",\"timestamp\":\"1589464122\"}";

    @BeforeEach
    public void setUp() {
        Client client = Client.create();
        target = client.resource("http://localhost:8080/action/new");
    }

    @Test
    void sendTest() {
        ClientResponse response = target.type("application/json").post(ClientResponse.class, actionJson);

        assertEquals("Saved successfully", response.getEntity(String.class));
        assertEquals(ClientResponse.Status.CREATED.getStatusCode(), response.getStatus());
    }
}