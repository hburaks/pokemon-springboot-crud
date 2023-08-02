package com.allianz.pokemon.database.entity;

import com.allianz.pokemon.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class CharacterEntity extends BaseEntity {
    @Column
    String name;
    @Column
    int age;
    @Enumerated(EnumType.STRING)
    PokemonTypeEnum pokemonTypeEnum;
}
