package sport.exercise.model;

import sport.exercise.dto.MappeableToDTO;
import sport.exercise.dto.SportDTO;

public class Sport implements MappeableToDTO<SportDTO> {

    private String sportName;
    private int level;

    public Sport(String sportName, int level) {
        this.sportName = sportName;
        this.level = level;
    }

    public boolean hasName(String name) {
        return this.sportName.equals(name);
    }
    @Override
    public void mapToDTO(SportDTO sportDTO) {
        sportDTO.setLevel(level);
        sportDTO.setSportName(sportName);
    }
}
