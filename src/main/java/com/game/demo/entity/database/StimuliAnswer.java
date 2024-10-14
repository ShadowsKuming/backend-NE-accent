package com.game.demo.entity.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The StimuliAnswer class represents a record in the `stimuli_group` table in the database.
 * This class is used to store information about audio files and their corresponding correct answers.
 * The `fileName` represents the name of the audio file, and the `level` represents the correct answer associated with that file.
 */
@Entity
@Table(name = "stimuli_group")
public class StimuliAnswer {

    // Name of the audio file (Primary Key)
    @Id
    @Column(name = "filename")
    private String fileName;

    // level associated with the audio file
    @Column(name = "level")
    private String level;

    // Correct answer associated with the audio file
    @Column(name = "correct_answer")
    private String correctAnswer;




    // Getters and Setters for each field

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
