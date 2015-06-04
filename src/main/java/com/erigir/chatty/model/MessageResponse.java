package com.erigir.chatty.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chrweiss on 6/4/15.
 */
public class MessageResponse {
    private Long timestamp = System.currentTimeMillis();
    private List<Message> msgs = new LinkedList<>();

    public List<Message> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Message> msgs) {
        this.msgs = msgs;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
