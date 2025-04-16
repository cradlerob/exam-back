package com.mifel.exam.persons.service;

import com.mifel.exam.persons.dto.PersonDto;
import com.mifel.exam.persons.entity.PersonEntity;

import java.util.List;

public interface PersonService {

    public PersonDto getPersonByName(String name);

    List<PersonDto> getPersons();
}
