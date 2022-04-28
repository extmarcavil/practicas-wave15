package com.example.linktracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseLinkDTO {
    private int index;

    public ResponseLinkDTO(int index) {
        this.index = index;
    }
}
