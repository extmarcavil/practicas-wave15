package agencyTurism.repository.impl;

import agencyTurism.entity.Localizador;
import agencyTurism.repository.LocalizadorRepository;
import agencyTurism.services.DataService;

public class LocalizadorRepositoryImpl implements LocalizadorRepository {

    private DataService dataService;

    public LocalizadorRepositoryImpl(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void saveLocalizador(Localizador localizador) {
        this.dataService.saveLocalizador(localizador);
    }
}
