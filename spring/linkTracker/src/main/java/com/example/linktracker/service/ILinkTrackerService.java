package com.example.linktracker.service;

import com.example.linktracker.dto.request.UrlLinkDTO;
import com.example.linktracker.dto.response.IdLinkDTO;
import com.example.linktracker.dto.response.MetricsLinkDTO;

public interface ILinkTrackerService {
    IdLinkDTO createLink(UrlLinkDTO urlDTO, String password);

    String getLink(int id, String password);

    MetricsLinkDTO getMetrics(Integer id);

    void invalidateLink(Integer id);
}
