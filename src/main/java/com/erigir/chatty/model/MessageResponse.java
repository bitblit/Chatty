package com.erigir.chatty.model;

/**
 * Created by chrweiss on 6/4/15.
 */
public class MessageResponse {
    private Long timestamp = System.currentTimeMillis();

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
