package com.meli.studenttest.repository;

import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractCrudRepository<ID, T> implements GenericRepository<ID, T> {

    protected List<T> repository;

    public AbstractCrudRepository() {
        initData();
    }

    public void initData() {
        repository = loadData();
    }

    protected void reload() {
        initData();
    }

    protected abstract List<T> loadData();

    public abstract void findByIdForUpdate(ID id, Consumer<T> callback);

}
