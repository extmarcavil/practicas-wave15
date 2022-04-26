package com.Spring.LinkTracker.repository;

import com.Spring.LinkTracker.dto.LinkDTO;

public interface ILinkRepository {

     Integer saveLink(String url);
     String getUrl(Integer id);
}
