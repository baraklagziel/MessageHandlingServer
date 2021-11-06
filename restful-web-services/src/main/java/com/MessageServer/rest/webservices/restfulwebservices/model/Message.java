package com.MessageServer.rest.webservices.restfulwebservices.model;

import com.MessageServer.rest.webservices.restfulwebservices.service.Type;

import javax.persistence.*;

@Entity
public abstract class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public Message(String content, Type type) {
        this.content = content;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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
        int value = getValue();
        return value > 0;
    }


}
