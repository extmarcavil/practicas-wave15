package com.Spring.LinkTracker.repository;

import com.Spring.LinkTracker.dto.LinkDTO;

public interface ILinkRepository {

     Integer saveLink(String url);
     LinkDTO getURL (Integer id);
}
