package com.sprint.be_java_hisp_w15_g10.Model;

public interface IIdInterface {
    int getId();
    <T> boolean compares(T field);
    void setId(int id);
}
