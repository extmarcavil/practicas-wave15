package com.Spring.LinkTracker.service;

import com.Spring.LinkTracker.dto.LinkDTO;

public interface ILinkService {

    Integer saveLink (String url);
    LinkDTO getURL (Integer id);
    LinkDTO redirect (Integer id);
    Integer metrics (Integer id);
    void invalidate(Integer id);
}
