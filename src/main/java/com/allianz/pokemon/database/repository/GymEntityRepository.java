package com.allianz.pokemon.database.repository;

import com.allianz.pokemon.database.entity.GymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GymEntityRepository extends JpaRepository<GymEntity, Long> {

    public List<GymEntity> getByEstablishDateIsLessThanEqualOrderByEstablishDateDesc(int date);
}
