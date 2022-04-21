package com.example.ejerciciocovid.repository;

import com.example.ejerciciocovid.model.Person;

import java.util.List;

public interface IPersonRepository {

    List<Person> getPersonsList();
}
