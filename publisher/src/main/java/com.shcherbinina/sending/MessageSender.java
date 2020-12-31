package com.shcherbinina.sending;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shcherbinina.generation.Message;
import com.shcherbinina.generation.MessageGeneration;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageSender {
    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    public void send() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/action/new");

        Message message = MessageGeneration.generateMessage();
        String jsonString = getJsonString(message);

        try {
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonString);
            if (response.getStatus() != 200 || response.getStatus() != 201) {
                logger.info("Output from Server {}", response.getEntity(String.class));
            } else {
                logger.info("Failed : HTTP error code : {}\nError: {}", response.getStatus(), response.getEntity(String.class));
            }
        } catch (Exception ex) {
            logger.error("Request Error: {}\nStack Trace: {}", ex.getMessage(), ex.getStackTrace());
        }
    }

    private String getJsonString(Message message) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(message);
        } catch(JsonProcessingException e) {
            logger.error("Failed: Convert json to String: {}", e.getStackTrace());
        }
        return jsonString;
    }
}
