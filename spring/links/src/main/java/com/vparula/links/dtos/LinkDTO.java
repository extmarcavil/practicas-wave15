package com.vparula.links.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {
    private int id;
    private String link;
    private boolean valido;
    private int visitas;

    public LinkDTO(int id, String link, boolean valido, int visitas) {
        this.id = id;
        this.link = link;
        this.valido = valido;
        this.visitas = visitas;
    }

    public LinkDTO() {
    }
}
