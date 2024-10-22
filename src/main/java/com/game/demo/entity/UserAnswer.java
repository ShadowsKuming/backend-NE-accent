package com.game.demo.entity;

import jakarta.persistence.*;

/**
 * Entity class representing the player's answers to questions in the game.
 * This class is used to record every question answered by the user,
 * along with the user's answer, the correct answer, and whether the answer was correct.
 */
@Entity
@Table(name = "user_answers")
@IdClass(UserAnswerId.class)
public class UserAnswer {

    @Id
    @Column(name = "question_number")
    private int questionNumber; // The number of the question being answered

    @Id
    @Column(name = "player_id")
    private int playerId; // The ID of the player who answered the question

    @Column(name = "question_name")
    private String questionName; // The name or description of the question

    @Column(name = "player_answer")
    private String playerAnswer; // The answer provided by the player

    @Column(name = "correct_answer")
    private String correctAnswer; // The correct answer to the question

    @Column(name = "is_correct")
    private Boolean isCorrect; // Whether the player's answer is correct (true/false)

    @Column(name = "question_level")
    private String questionLevel;

    // No-argument constructor required by JPA
    protected UserAnswer() {}

    // Parameterized constructor for easy object creation


    public UserAnswer(int questionNumber, int playerId, String questionName, String playerAnswer, String correctAnswer, Boolean isCorrect, String questionLevel) {
        this.questionNumber = questionNumber;
        this.playerId = playerId;
        this.questionName = questionName;
        this.playerAnswer = playerAnswer;
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
        this.questionLevel = questionLevel;
    }

    // Getters and setters
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

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getPlayerAnswer() {
        return playerAnswer;
    }

    public void setPlayerAnswer(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }
}
