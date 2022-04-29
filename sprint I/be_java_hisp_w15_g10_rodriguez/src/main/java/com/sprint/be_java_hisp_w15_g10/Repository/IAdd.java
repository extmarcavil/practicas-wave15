package com.sprint.be_java_hisp_w15_g10.Repository;

public interface IAdd<T> {
    void add(T t);
    int getNextId();
    <M> T exist(M i);
}
