package com.game.demo.dao;

import com.game.demo.entity.GamePerformance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamePerformanceRepository extends JpaRepository<GamePerformance, Long> {

    List<GamePerformance> findTop20ByOrderByScoreDesc();
    List<GamePerformance> findAllByOrderByScoreDesc();
}
