package com.linktacker.linktacker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.net.URL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginaResponseDTO implements Serializable {
    private int linkId;
    private URL url;

}
