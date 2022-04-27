package com.meli.blog.repository;

import javax.annotation.PostConstruct;
import java.util.List;

public abstract class AbstractRepository<T, ID> implements GenericRepository<T, ID> {

    protected List<T> repository;

    @PostConstruct
    private void loadData() {
        repository = initData();
    }

    public abstract List<T> initData();
}
