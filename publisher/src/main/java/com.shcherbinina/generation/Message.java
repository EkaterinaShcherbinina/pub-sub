package com.shcherbinina.generation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Produces(MediaType.APPLICATION_JSON)
public class Message {
    private long id;
    private long msisdn;
    private String action;
    private long timestamp;
}
