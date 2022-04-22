package sport.exercise.dto;

import lombok.Getter;
import lombok.Setter;
import sport.exercise.model.Sport;

@Getter
@Setter
public class SportDTO {

    private String sportName;
    private int level;

    public SportDTO(Sport eachSport) {
        eachSport.mapToDTO(this);
    }
}
