package com.game.demo.entity.database;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents the composite primary key for the UserAnswer entity.
 * It combines the questionNumber and playerId fields to uniquely identify each record in the UserAnswer table.
 *
 * This class is used in conjunction with the @IdClass annotation in the UserAnswer entity class.
 * By implementing Serializable and overriding the equals() and hashCode() methods,
 * this class ensures that the composite key is correctly handled by JPA.
 */
public class UserAnswerId implements Serializable {

    private int questionNumber; // The number of the question in the quiz or game
    private int playerId;       // The ID of the player who answered the question

    // Default no-argument constructor required by JPA
    public UserAnswerId() {}

    // Parameterized constructor for easy creation of composite key instances
    public UserAnswerId(int questionNumber, int playerId) {
        this.questionNumber = questionNumber;
        this.playerId = playerId;
    }

    // Getters and Setters
    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    // The equals() method is necessary to compare composite key objects correctly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnswerId that = (UserAnswerId) o;
        return questionNumber == that.questionNumber && playerId == that.playerId;
    }

    // The hashCode() method is necessary for using composite key objects in hash-based collections
    @Override
    public int hashCode() {
        return Objects.hash(questionNumber, playerId);
    }
}
