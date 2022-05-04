package com.spring.ejerciciolinktracker.service;

import com.spring.ejerciciolinktracker.dto.ResponseLinkDTO;

public interface ILinkService {
    String createLink(String url);

    String getLinkRedirect(String linkId);
}
