package com.example.linktracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestLinkDTO implements Serializable {
    private String url;

    public RequestLinkDTO(String url) {
        this.url = url;
    }

    public RequestLinkDTO() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
