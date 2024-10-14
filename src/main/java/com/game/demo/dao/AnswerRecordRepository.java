package com.game.demo.dao;

import com.game.demo.entity.database.UserAnswer;
import com.game.demo.entity.database.UserAnswerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRecordRepository extends JpaRepository<UserAnswer, UserAnswerId> {
}
