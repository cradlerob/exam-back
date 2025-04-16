package com.mifel.exam.persons.controller;

import com.mifel.exam.persons.dto.PersonDto;
import com.mifel.exam.persons.dto.GenericResponse;
import com.mifel.exam.persons.dto.RequestPerson;
import com.mifel.exam.persons.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class Controller {

    @Autowired
    private PersonService personService;

    @PostMapping("find")
    @PreAuthorize("hasRole(‘ADMIN’)")
    public ResponseEntity<GenericResponse<PersonDto>> getCatalogs(@RequestBody RequestPerson request){
        GenericResponse<PersonDto> response;
        HttpStatus status=HttpStatus.OK;
        try{
            response= GenericResponse.<PersonDto>builder().status("ok").message("ok").body(personService.getPersonByName(request.getName())).build();
        }catch (Exception e){
            status=HttpStatus.INTERNAL_SERVER_ERROR;
            response= GenericResponse.<PersonDto>builder().status("error").message(e.getMessage()).build();
        }
        return new ResponseEntity<>(response,status);
    }
    @GetMapping("all")
    @PreAuthorize("hasRole(‘USER’)")
    public ResponseEntity<GenericResponse<List<PersonDto>>> getAllCatalogs(){
        GenericResponse<List<PersonDto>> response;
        HttpStatus status=HttpStatus.OK;
        try{
            response= GenericResponse.<List<PersonDto>>builder().status("ok").message("ok").body(personService.getPersons()).build();
        }catch (Exception e){
            status=HttpStatus.INTERNAL_SERVER_ERROR;
            response= GenericResponse.<List<PersonDto>>builder().status("error").message(e.getMessage()).build();
        }
        return new ResponseEntity<>(response,status);
    }
}
