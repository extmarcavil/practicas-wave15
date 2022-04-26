package com.example.linktracker.repositories;

import com.example.linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    Integer saveLink(Link link);
    Optional<Link> getLink(Integer id);
}
