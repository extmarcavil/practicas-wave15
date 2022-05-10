package com.example.linktracker.services;

import com.example.linktracker.dto.RequestDTO;
import com.example.linktracker.dto.ResponseDTO;

public interface LinkService {

    ResponseDTO save(RequestDTO link);
    void invalidate(Integer id);
    String getUrl(Integer linkId, String password);
    ResponseDTO getMetrics(Integer linkId);
}
