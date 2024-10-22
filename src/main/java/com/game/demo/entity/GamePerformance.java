package com.game.demo.entity;

import jakarta.persistence.*;

/**
 * The GamePerformance class represents a record of a player's performance in the game.
 * It maps to the `game_performance` table in the database and stores information
 * such as the player's ID, score, the number of questions answered,
 * and the number of correct and incorrect answers.
 */
@Entity
@Table(name = "game_performance")
public class GamePerformance {

    // Unique identifier for each game performance record (Primary Key)
    @Id
    @Column(name = "user_id")
    private int id;

    // The player's score in the game
    @Column(name = "score")
    private int score;

    // The number of questions the player has answered
    @Column(name = "question_number")
    private int questionNumber;

    // The number of correct answers given by the player
    @Column(name = "right_answer_num_county")
    private int right_answer_num_county;

    // The number of incorrect answers given by the player
    @Column(name = "wrong_answer_num_county")
    private int wrong_answer_num_county;

    @Column(name = "right_answer_num_borough")
    private int right_answer_num_borough;

    @Column(name = "wrong_answer_num_borough")
    private int wrong_answer_num_borough;

    // No-argument constructor required by JPA
    protected GamePerformance() {
    }

    // Parameterized constructor for easy object creation

    public GamePerformance(int wrong_answer_num_borough, int right_answer_num_borough, int wrong_answer_num_county, int right_answer_num_county, int questionNumber, int score, int id) {
        this.wrong_answer_num_borough = wrong_answer_num_borough;
        this.right_answer_num_borough = right_answer_num_borough;
        this.wrong_answer_num_county = wrong_answer_num_county;
        this.right_answer_num_county = right_answer_num_county;
        this.questionNumber = questionNumber;
        this.score = score;
        this.id = id;
    }


    // Getters and Setters for each field

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getRight_answer_num_county() {
        return right_answer_num_county;
    }

    public void setRight_answer_num_county(int right_answer_num_county) {
        this.right_answer_num_county = right_answer_num_county;
    }

    public int getWrong_answer_num_county() {
        return wrong_answer_num_county;
    }

    public void setWrong_answer_num_county(int wrong_answer_num_county) {
        this.wrong_answer_num_county = wrong_answer_num_county;
    }

    public int getRight_answer_num_borough() {
        return right_answer_num_borough;
    }

    public void setRight_answer_num_borough(int right_answer_num_borough) {
        this.right_answer_num_borough = right_answer_num_borough;
    }

    public int getWrong_answer_num_borough() {
        return wrong_answer_num_borough;
    }

    public void setWrong_answer_num_borough(int wrong_answer_num_borough) {
        this.wrong_answer_num_borough = wrong_answer_num_borough;
    }
}
