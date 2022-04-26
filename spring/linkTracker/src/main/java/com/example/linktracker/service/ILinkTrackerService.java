package com.example.linktracker.service;

import com.example.linktracker.dto.request.UrlLinkDTO;
import com.example.linktracker.dto.response.IdLinkDTO;

public interface ILinkTrackerService {
    IdLinkDTO createLink(UrlLinkDTO urlDTO);
}
