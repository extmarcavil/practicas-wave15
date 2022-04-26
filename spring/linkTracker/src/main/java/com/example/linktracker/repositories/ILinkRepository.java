package com.example.linktracker.repositories;

import com.example.linktracker.model.Link;

import java.util.List;
import java.util.Optional;

public interface ILinkRepository {
    Link saveLink(Link link);
    String getLink(Integer id);
    List<Link> mostrarLinks();
}
