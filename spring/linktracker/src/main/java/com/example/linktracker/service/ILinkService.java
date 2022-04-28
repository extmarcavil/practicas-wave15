package com.example.linktracker.service;

import com.example.linktracker.dto.RequestLinkDTO;
import com.example.linktracker.dto.ResponseLinkDTO;

public interface ILinkService {
    ResponseLinkDTO create(RequestLinkDTO req);
    String findByIndex(int index);
}
