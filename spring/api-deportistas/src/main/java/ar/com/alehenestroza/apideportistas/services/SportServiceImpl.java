package ar.com.alehenestroza.apideportistas.services;

import ar.com.alehenestroza.apideportistas.models.Sport;
import ar.com.alehenestroza.apideportistas.repositories.SportRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class SportServiceImpl implements SportService {
    private final SportRepository sportRepository;

    @Override
    public List<Sport> findSports() {
        return this.sportRepository.getSports();
    }

    @Override
    public Sport findSport(String name) {
        return this.sportRepository.getSport(name);
    }
}
