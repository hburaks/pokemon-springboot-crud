package com.allianz.pokemon.service;

import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import com.allianz.pokemon.database.repository.PokemonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    PokemonEntityRepository pokemonEntityRepository;
public List<PokemonEntity> getPokemonEntities(){
    return pokemonEntityRepository.findAll();
}
    public List<PokemonEntity> getPokemonByNameStartsWith(String name) {
        List<PokemonEntity> pokemonEntities = pokemonEntityRepository.getPokemonEntityByNameStartingWith(name);
        return pokemonEntities;
    }

    public List<PokemonEntity> getPokemonByType(PokemonTypeEnum pokemonTypeEnum) {
        List<PokemonEntity> pokemonEntities = pokemonEntityRepository.getPokemonEntityByPokemonTypeEnum(pokemonTypeEnum);
        return pokemonEntities;
    }

    public PokemonEntity createPokemon(String name, int power, PokemonTypeEnum pokemonTypeEnum){
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(name);
        pokemonEntity.setPower(power);
        pokemonEntity.setPokemonTypeEnum(pokemonTypeEnum);

        pokemonEntityRepository.save(pokemonEntity);

        return pokemonEntity;
    }


}
