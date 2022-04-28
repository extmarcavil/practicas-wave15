package com.example.linktracker.repository;

import com.example.linktracker.model.Link;

public interface ILinkRepository {
    int create(Link link);
    Link findByIndex(int index);
}
