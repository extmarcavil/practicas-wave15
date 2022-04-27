package com.car.concessionaire.repository;

import javax.annotation.PostConstruct;
import java.util.List;

public abstract class AbstractRepository<T, ID> implements GenericRepository<T, ID> {

    protected List<T> repository;

    @PostConstruct
    private void loadData() {
        repository = initData();
    }

    public void reset() {
        repository.clear();
        repository = initData();
    }

    protected abstract List<T> initData();

    protected abstract void generateId(T t);
}
