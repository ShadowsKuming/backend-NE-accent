package com.game.demo.dao;

import com.game.demo.entity.UserAnswer;
import com.game.demo.entity.UserAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRecordRepository extends JpaRepository<UserAnswer, UserAnswerId> {
}
