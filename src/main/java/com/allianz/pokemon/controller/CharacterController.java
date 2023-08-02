package com.allianz.pokemon.controller;

import com.allianz.pokemon.database.entity.CharacterEntity;
import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import com.allianz.pokemon.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("character")
    public ResponseEntity<List<CharacterEntity>> getCharacterList() {
        return new ResponseEntity<>(characterService.getCharacterEntities(), HttpStatus.OK);
    }

    @GetMapping("Character/name/{name}")
    public ResponseEntity<CharacterEntity> getCharacterByName(@PathVariable String name){
        return new ResponseEntity<>(characterService.getCharacterByName(name), HttpStatus.OK);
    }

    @GetMapping("character/type/{type}")
    public ResponseEntity<List<CharacterEntity>> getCharacterByType(@PathVariable PokemonTypeEnum pokemonTypeEnum){
        return new ResponseEntity<>(characterService.getCharacterByType(pokemonTypeEnum),HttpStatus.OK);
    }

    @PostMapping("character")
    public ResponseEntity<CharacterEntity> createCharacter(@RequestBody CharacterEntity characterEntity){
        return new ResponseEntity<>(characterService.createCharacter(characterEntity.getName(),
                characterEntity.getAge(),
                characterEntity.getPokemonTypeEnum()), HttpStatus.CREATED);
    }

}
