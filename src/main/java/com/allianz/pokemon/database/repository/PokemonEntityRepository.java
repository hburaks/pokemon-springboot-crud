package com.allianz.pokemon.database.repository;

import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonEntityRepository extends JpaRepository<PokemonEntity, Long>{
    public List<PokemonEntity> getPokemonEntityByNameStartingWith(String name);
    public List<PokemonEntity> getPokemonEntityByPokemonTypeEnum(PokemonTypeEnum pokemonTypeEnum);
}
