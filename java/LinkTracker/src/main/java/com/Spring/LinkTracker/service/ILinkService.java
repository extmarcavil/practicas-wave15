package com.Spring.LinkTracker.service;

import com.Spring.LinkTracker.dto.LinkDTO;

public interface ILinkService {

    Integer saveLink(String url);
    public String getURL (Integer id);
}
