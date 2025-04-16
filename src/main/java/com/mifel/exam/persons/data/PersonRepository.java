package com.mifel.exam.persons.data;

import com.mifel.exam.persons.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

    Optional<PersonEntity> findFirstByNombre(String nombre);
}
