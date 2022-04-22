package sport.exercise.service;

import sport.exercise.dto.SportDTO;

import java.util.ArrayList;

public interface SportServiceInterface {

    ArrayList<SportDTO> getAllSports();
    SportDTO getSport(String name);

}
