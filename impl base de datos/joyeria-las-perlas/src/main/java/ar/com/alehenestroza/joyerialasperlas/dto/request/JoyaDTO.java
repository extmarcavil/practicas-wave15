package ar.com.alehenestroza.joyerialasperlas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JoyaDTO {
    private String name;
    private String material;
    private Double weight;
    private String uniqueQuality;
    private Boolean hasStone;
}
