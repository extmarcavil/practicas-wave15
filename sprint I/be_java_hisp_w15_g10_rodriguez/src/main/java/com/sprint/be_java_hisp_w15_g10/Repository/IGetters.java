package com.sprint.be_java_hisp_w15_g10.Repository;

import java.util.List;
import java.util.Optional;

public interface IGetters<T> {
    List<T> getAll();
    Optional<T> getById(int id);
}
