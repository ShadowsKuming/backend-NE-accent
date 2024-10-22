package com.game.demo.dao;

import com.game.demo.entity.StimuliAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StimuliRepository extends JpaRepository<StimuliAnswer,Long> {

    @Query(value = "SELECT * FROM stimuli_group WHERE level = :level ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<StimuliAnswer> findRandomEntitiesByLevel(@Param("level") String level, @Param("limit") int limit);
}
