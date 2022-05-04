package com.spring.ejerciciolinktracker.repository;

import com.spring.ejerciciolinktracker.dto.Link;

import java.util.Optional;

public interface ILinkRepository {
    String createLink(String url);

    Optional<Link> getUrlRedirect(String linkId);
}
