package com.allianz.pokemon.database.repository;

import com.allianz.pokemon.database.entity.CharacterEntity;
import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import com.allianz.pokemon.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {
    public CharacterEntity getCharacterEntityByName(String name);
    public List<CharacterEntity> getCharacterEntitiesByPokemonTypeEnum(PokemonTypeEnum pokemonTypeEnum);
}
