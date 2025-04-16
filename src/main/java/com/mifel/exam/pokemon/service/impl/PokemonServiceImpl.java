package com.mifel.exam.pokemon.service.impl;

import com.mifel.exam.pokemon.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Service
@Slf4j(topic = "Pokemon")
public class PokemonServiceImpl implements PokemonService {

    @Value("${url.api-pokemon}")
    private String urlApi;
    @Override
    public Map<String, Object> findPokemon(String pokemonName) throws URISyntaxException {
        try{
            return new RestTemplate().exchange(new URI(urlApi+pokemonName), HttpMethod.GET,null,Map.class).getBody();
        }catch (Exception e){
            log.info("Ocurrio un error al consultar pokemon:{0} Error: {1} ",pokemonName,e.getMessage());
            throw e;
        }
    }
}
