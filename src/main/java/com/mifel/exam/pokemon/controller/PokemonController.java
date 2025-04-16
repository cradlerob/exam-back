package com.mifel.exam.pokemon.controller;

import com.mifel.exam.persons.dto.GenericResponse;
import com.mifel.exam.pokemon.dto.PokemonRequest;
import com.mifel.exam.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;
    @PostMapping(value = "/catch",produces = "application/json",consumes = "application/json")
    public ResponseEntity<GenericResponse<Object>> getPokemon(@RequestBody PokemonRequest pokemon){
        GenericResponse<Object> response;
        HttpStatus status=HttpStatus.OK;
        try{
            Map pokemonMap=pokemonService.findPokemon(pokemon.getPokemonName());
            response=GenericResponse.builder()
                    .status("Ok")
                    .message("Pokemon encontrado!")
                    .body(pokemonMap).build();
        }catch (Exception e){
            response=GenericResponse.builder().message(e.getMessage()).status("Error").build();
            status =HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response,status);
    }
}
