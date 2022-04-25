package com.example.linkpractice.DTO.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLinkDTOResponse {
    int linkID;

    public CreateLinkDTOResponse(int linkID) {
        this.linkID = linkID;
    }
}
