package com.shcherbinina.controllers;

import com.shcherbinina.dto.entity.ActionDto;
import com.shcherbinina.dto.services.IActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/action")
public class ActionController {
    @Autowired
    private IActionService actionService;
    private static final Logger logger = LoggerFactory.getLogger(
            ActionController.class);

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postAction(@RequestBody @Valid ActionDto actionDto) {
        logger.error("POST: postAction method was called: /action/new");
        actionService.addNewAction(actionDto);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }
}
