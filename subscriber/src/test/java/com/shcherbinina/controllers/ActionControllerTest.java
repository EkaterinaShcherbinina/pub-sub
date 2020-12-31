package com.shcherbinina.controllers;

import com.shcherbinina.dto.entity.ActionDto;
import com.shcherbinina.dto.services.ActionService;
import com.shcherbinina.dto.services.IActionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@WebMvcTest(value = ActionController.class)
class ActionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActionService actionService;

    private String actionJson = "{\"id\":\"1\",\"msisdn\":\"123456789\",\"action\":\"PURCHASE\",\"timestamp\":\"1589464122\"}";
    @Test
    void postAction() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/action/new")
                .accept(MediaType.APPLICATION_JSON).content(actionJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }
}