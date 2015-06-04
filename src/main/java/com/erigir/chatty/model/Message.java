package com.erigir.chatty.model;

/**
 * Created by chrweiss on 6/4/15.
 */
public class Message {
    private Long timestamp;
    private String userid;
    private String message;

    public Message() {
    }

    public Message(Long timestamp, String userid, String message) {
        this.timestamp = timestamp;
        this.userid = userid;
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
