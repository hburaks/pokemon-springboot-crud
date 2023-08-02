package com.allianz.pokemon.model;

import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Character {
    String name;
    int age;
    PokemonTypeEnum pokemonTypeEnum;
}
