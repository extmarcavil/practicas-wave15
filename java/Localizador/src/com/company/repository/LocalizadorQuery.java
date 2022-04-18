package com.company.repository;

import java.util.List;
import java.util.Map;

public interface LocalizadorQuery {
    Integer getTotalLocalizadores();
    Integer getTotalReservas();
    Map<String, List<Object>> getPaquetesPorTipo();
    Integer getTotalVentas();
    double getPromedioVentas();
}
