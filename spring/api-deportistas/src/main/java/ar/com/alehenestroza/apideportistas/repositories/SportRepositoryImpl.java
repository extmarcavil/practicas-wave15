package ar.com.alehenestroza.apideportistas.repositories;

import ar.com.alehenestroza.apideportistas.models.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SportRepositoryImpl implements SportRepository {
    private List<Sport> sports;

    public SportRepositoryImpl() {
        this.sports = new ArrayList<>(Arrays.asList(
                new Sport("Football", "Primera"),
                new Sport("Tenis", "Amateur"),
                new Sport("Boxeo", "Peso Mediano")
        ));
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    @Override
    public List<Sport> getSports() {
        return this.sports;
    }

    @Override
    public Sport getSport(String name) {
        return this.sports.stream()
                .filter(sp -> sp.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
