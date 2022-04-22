package searcher.covid.model;

import searcher.covid.dto.MappeableToDTO;
import searcher.covid.dto.SymptomDTO;

public class Symptom implements MappeableToDTO<SymptomDTO> {

    private int code;
    private String symptomName;
    private int riskLevel;

    public Symptom(int code,String symptomName, int riskLevel) {
        this.code = code;
        this.symptomName = symptomName;
        this.riskLevel = riskLevel;
    }

    public boolean hasName(String name) {
        return this.symptomName.equals(name);
    }
    @Override
    public void mapToDTO(SymptomDTO symptomDTO) {
        symptomDTO.setCode(code);
        symptomDTO.setRiskLevel(riskLevel);
        symptomDTO.setSymptomName(symptomName);
    }
}
