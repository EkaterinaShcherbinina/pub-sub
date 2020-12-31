package com.shcherbinina.dto.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@Builder
public class ActionDto {

    @Positive(message = "message Id must be > 0")
    private long id;

    @NotEmpty
    private long msisdn;

    @NotEmpty
    private String action;

    @NotEmpty
    private long timestamp;
}
