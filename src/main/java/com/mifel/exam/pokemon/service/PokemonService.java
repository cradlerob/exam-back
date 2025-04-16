package com.mifel.exam.pokemon.service;

import java.net.URISyntaxException;
import java.util.Map;

public interface PokemonService {

    public Map<String,Object> findPokemon(String pokemonName) throws URISyntaxException;
}
