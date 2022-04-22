package sport.exercise.service;

import org.springframework.stereotype.Service;
import sport.exercise.dto.SportDTO;
import sport.exercise.model.Sport;
import sport.exercise.repository.SportsSearcherInterface;

import java.util.ArrayList;

@Service
public class SportService implements SportServiceInterface{

    SportsSearcherInterface sportRepository;

    public SportService(SportsSearcherInterface sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public ArrayList<SportDTO> getAllSports() {
        ArrayList<SportDTO> listOfSportDTO = new ArrayList<>();
        ArrayList<Sport> listOfSports = this.sportRepository.getAllSports();
        for( Sport eachSport : listOfSports ){
            listOfSportDTO.add(new SportDTO(eachSport));
        }
        return (ArrayList<SportDTO>) listOfSportDTO.clone();
    }

    @Override
    public SportDTO getSport(String name) {
        Sport aSport =  this.sportRepository.getSport(name);
        return new SportDTO(aSport);
    }
}
