package searcher.covid.repository;

import searcher.covid.model.Person;
import searcher.covid.model.Symptom;

import java.util.ArrayList;

public interface RepositoryInterface {

     ArrayList<Person> getAllPersonsInRiskGroup();
     ArrayList<Symptom> getAllSymptoms();
     Symptom getRiskLevelOf(String name);
}
