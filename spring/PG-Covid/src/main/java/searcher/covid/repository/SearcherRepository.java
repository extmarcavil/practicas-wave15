package searcher.covid.repository;

import org.springframework.stereotype.Repository;
import searcher.covid.model.Person;
import searcher.covid.model.Symptom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Repository
public class SearcherRepository implements RepositoryInterface {

    ArrayList<Symptom> listOfSavedSymptoms;
    ArrayList<Person> listOfPerson;

    public SearcherRepository() {
        this.initialize();
    }

    private void initialize() {
        Symptom headache = new Symptom(123,"DolorDeCabeza",1);
        Symptom cough = new Symptom(233,"Tos",2);
        Symptom feber = new Symptom(7783,"Fiebre",3);
        Symptom vomit = new Symptom(19,"Vomitos",1);

        listOfSavedSymptoms = new ArrayList<>(Arrays.asList( headache,cough,feber,vomit ));

        listOfPerson = new ArrayList<>(Arrays.asList(
                Person.newPerson(22,"Robert","Patinson",30),
                Person.newPersonWithSymptoms(1,"Tom","Holland",17,Arrays.asList(cough,feber)),
                Person.newPerson(2,"Andrew","Garfield",30),
                Person.newPersonWithSymptoms(23,"Will","Smith",60,Arrays.asList(vomit)),
                Person.newPerson(87,"Meryl","Streep",70),
                Person.newPersonWithSymptoms(105,"Robert","De Niro",70,Arrays.asList(headache,vomit))
        ) );

    }

    @Override
    public ArrayList<Person> getAllPersonsInRiskGroup() {
        // Visualizar a las personas que puedan ser del grupo de riesgo.
        // Para ello, necesitamos visualizar un listado con el nombre y
        // el apellido de aquellas personas mayores de 60 años que
        // puedan poseer al menos un síntoma asociado.
        // Como para la respuesta de esta consulta habrá que tener
        // en cuenta la relación entre las dos tablas,
        // se recomienda utilizar el patrón DTO.
        return (ArrayList<Person>) listOfPerson
                .stream()
                .filter(Person::isOldAge)
                .filter(Person::hasSymptoms)
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<Symptom> getAllSymptoms() {
        return (ArrayList<Symptom>) listOfSavedSymptoms.clone();
    }

    @Override
    public Symptom getRiskLevelOf(String name) {
        return listOfSavedSymptoms
                .stream()
                .filter(x->x.hasName(name))
                .findFirst()
                .orElse(new Symptom(0,"Desconocido",0));
    }
}
