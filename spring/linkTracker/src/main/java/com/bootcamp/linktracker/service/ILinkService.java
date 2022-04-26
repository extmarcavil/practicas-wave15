package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dtos.LinkDTO;

public interface ILinkService {
    Integer save(LinkDTO link);
    String getLink(Integer id, String password);
    Integer getCount(Integer id);
    LinkDTO invalidate(Integer id);
}
