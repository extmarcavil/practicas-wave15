package com.example.demoORM.service;

import com.example.demoORM.model.MiniSerie;
import com.example.demoORM.repository.IMiniSerieRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiniSerieService implements IMiniSerieService {

    private final IMiniSerieRepository repo;

    public MiniSerieService(IMiniSerieRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<MiniSerie> getMiniSeries() {
        List<MiniSerie> miniSeriesList = repo.findAll();
        return miniSeriesList;
    }

    @Override
    public MiniSerie saveMiniSerie(MiniSerie serie) {
        try {
            repo.save(serie);
        } catch (Exception e) {
            System.out.println(e);
        }
        return serie;
    }

    @Override
    public void deleteMiniSerie(Long id) {
        try {
            repo.deleteById(id);
            System.out.println("Miniserie with ID " + id + "was deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public MiniSerie findSerie(Long id) {
        System.out.println("Searching serie with ID: " + id);
        return repo.findById(id).orElse(null);
    }


}
