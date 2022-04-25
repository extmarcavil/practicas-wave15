package com.example.linkpractice.service;


public interface IService {
    Integer createLink(String link, String password);
    String redirect(Integer id);
    Integer getVisits(Integer id);
    void invalidate(Integer id);
}
