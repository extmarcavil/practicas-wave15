package searcher.covid.dto;

import lombok.Getter;
import lombok.Setter;
import searcher.covid.model.Symptom;

@Getter
@Setter
public class SymptomDTO {

    private int code;
    private String symptomName;
    private int riskLevel;

    public SymptomDTO(Symptom eachSymptom) {
        eachSymptom.mapToDTO(this);
    }
}
