package com.mifel.exam.persons.service.impl;

import com.mifel.exam.persons.data.PersonRepository;
import com.mifel.exam.persons.dto.PersonDto;
import com.mifel.exam.persons.entity.PersonEntity;
import com.mifel.exam.persons.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service( "CatalogService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public PersonDto getPersonByName(String name) {
        PersonEntity entity=personRepository.findFirstByNombre(name).orElseThrow();
        return PersonDto.builder().email(entity.getEmail()).id(entity.getId()).nombre(entity.getNombre()).telefono(entity.getTelefono()).build();
    }

    @Override
    public List<PersonDto> getPersons() {
        List<PersonEntity> entities=personRepository.findAll();
        List<PersonDto> listDto=new ArrayList<>();
        entities.forEach(entity->{
            listDto.add(PersonDto.builder().email(entity.getEmail()).id(entity.getId()).nombre(entity.getNombre()).telefono(entity.getTelefono()).build());
        });
        return listDto;
    }
}
