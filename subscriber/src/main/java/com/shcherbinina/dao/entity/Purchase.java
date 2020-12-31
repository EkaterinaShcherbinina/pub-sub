package com.shcherbinina.dao.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "message_id", nullable = false)
    private long messageId;

    @Column(name = "msisdn", nullable = false)
    private long msisdn;

    @Column(name = "modify_time", nullable = false)
    private long timestamp;

    public Purchase () {
    }

    public Purchase (long id, long messageId, long msisdn, long timestamp) {
        this.id = id;
        this.messageId = messageId;
        this.msisdn = msisdn;
        this.timestamp = timestamp;
    }
}
