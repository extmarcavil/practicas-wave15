package com.car.concessionaire.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface QueryFilter<T> {

    List<T> filterByDates(LocalDate since, LocalDate to);

    List<T> filterByPrices(BigDecimal since, BigDecimal to);

}
