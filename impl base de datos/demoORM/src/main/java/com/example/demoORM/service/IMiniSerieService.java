package com.example.demoORM.service;

import com.example.demoORM.model.MiniSerie;

import java.util.List;

public interface IMiniSerieService {

    List<MiniSerie> getMiniSeries ();
    MiniSerie saveMiniSerie (MiniSerie serie);
    void deleteMiniSerie (Long id);
    MiniSerie findSerie (Long id);

}
