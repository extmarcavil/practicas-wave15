package com.bootcamp.linktracker.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    @NotNull
    private String url;
    @NotNull
    private String password;
}
