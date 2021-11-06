package com.MessageServer.rest.webservices.restfulwebservices.model;

import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;

import javax.persistence.*;

@Entity
public abstract class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Type type;
    protected int value;

    public String getContent() {
        return content;
    }
    public Long getId() {
        return id;
    }

    public abstract int getValue();

    protected void setValue(int value) {
        this.value = value;
    }

    public boolean isPositive() {
        return value > 0;
    }

    public Message(String content, Type type) {
        this.content = content;
        this.type = type;
    }
}
