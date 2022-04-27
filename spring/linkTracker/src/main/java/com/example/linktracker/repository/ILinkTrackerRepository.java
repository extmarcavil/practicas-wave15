package com.example.linktracker.repository;

public interface ILinkTrackerRepository {
    int createLink(String url, String password);

    String getLink(int id, String password);

    int getMetrics(Integer id);

    void invalidateLink(Integer id);
}
