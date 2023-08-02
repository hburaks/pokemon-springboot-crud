package com.allianz.pokemon.controller;

import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import com.allianz.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("pokemon")
    public ResponseEntity<List<PokemonEntity>> getPokemonEntities(){
        return new ResponseEntity<>(pokemonService.getPokemonEntities(),HttpStatus.OK);
    }

    @GetMapping("pokemon/name/{name}")
    public ResponseEntity<List<PokemonEntity>> getPokemonByNameStartsWith(@PathVariable String name){
        return new ResponseEntity<>(pokemonService.getPokemonByNameStartsWith(name),HttpStatus.OK);
    }

    @GetMapping("pokemon/type/{type}")
    public ResponseEntity<List<PokemonEntity>> getPokemonByType(@PathVariable PokemonTypeEnum type){
        return new ResponseEntity<>(pokemonService.getPokemonByType(type),HttpStatus.OK);
    }

    @PostMapping("pokemon")
    public ResponseEntity<PokemonEntity> createPokemon(@RequestBody PokemonEntity pokemonEntity){
        PokemonEntity pokemon = pokemonService.createPokemon(
                pokemonEntity.getName(),
                pokemonEntity.getPower(),
                pokemonEntity.getPokemonTypeEnum()
        );
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }
    //TODO: If type enum creates conflict, use PokemonTypeEnum pokemonTypeEnum = PokemonTypeEnum.value.of()

}
