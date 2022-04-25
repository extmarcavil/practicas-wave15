package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

public interface ILinkRepository {
    Integer save(Link link);
    Link getLink(Integer id);
    Integer getCount(Integer id);
    Link invalidate(Integer id);
    void update(Link link);
}
