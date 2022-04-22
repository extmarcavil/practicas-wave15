package searcher.covid.service;

import searcher.covid.dto.SymptomDTO;

import java.util.ArrayList;

public interface SymptomServiceInterface {

    ArrayList<SymptomDTO> getAllSymptoms();
    SymptomDTO getRiskLevelOf(String name);

}
