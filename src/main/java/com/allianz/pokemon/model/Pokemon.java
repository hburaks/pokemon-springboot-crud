package com.allianz.pokemon.model;

import com.allianz.pokemon.database.entity.PokemonTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pokemon {
    String name;
    int power;
    PokemonTypeEnum pokemonTypeEnum;
}
