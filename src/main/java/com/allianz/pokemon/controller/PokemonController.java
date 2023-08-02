package com.allianz.pokemon.controller;

import com.allianz.pokemon.database.entity.CharacterEntity;
import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import com.allianz.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("pokemon/name/{name}")
    public ResponseEntity<PokemonEntity> getPokemonByName(@PathVariable String name) {
        return new ResponseEntity<>(pokemonService.getPokemonByName(name), HttpStatus.OK);
    }

    @GetMapping("pokemon")
    public ResponseEntity<List<PokemonEntity>> getPokemonEntities() {
        return new ResponseEntity<>(pokemonService.getPokemonEntities(), HttpStatus.OK);
    }

    @GetMapping("pokemon/name/start/{name}")
    public ResponseEntity<List<PokemonEntity>> getPokemonByNameStartsWith(@PathVariable String name) {
        return new ResponseEntity<>(pokemonService.getPokemonByNameStartsWith(name), HttpStatus.OK);
    }

    @GetMapping("pokemon/type/{type}")
    public ResponseEntity<List<PokemonEntity>> getPokemonByType(@PathVariable PokemonTypeEnum type) {
        return new ResponseEntity<>(pokemonService.getPokemonByType(type), HttpStatus.OK);
    }

    @PostMapping("pokemon")
    public ResponseEntity<PokemonEntity> createPokemon(@RequestBody PokemonEntity pokemonEntity) {
        PokemonEntity pokemon = pokemonService.createPokemon(
                pokemonEntity.getName(),
                pokemonEntity.getPower(),
                pokemonEntity.getPokemonTypeEnum()
        );
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    @GetMapping("pokemonName/{pokemonName}/characterName/{characterName}")
    public  ResponseEntity<List<Object>> getCharacterAndPokemon(@PathVariable String pokemonName, @PathVariable String characterName){
        return new ResponseEntity<>(pokemonService.getCharacterAndPokemon(characterName,pokemonName),HttpStatus.OK);
    }
}
