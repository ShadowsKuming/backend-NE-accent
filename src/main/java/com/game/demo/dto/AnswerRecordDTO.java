package com.game.demo.dto;

import com.game.demo.entity.UserAnswer;

public class AnswerRecordDTO {
    private int questionNumber;
    private String questionText;
    private String userAnswer;
    private String correctAnswer;
    private boolean isCorrect;
    private String questionLevel;


    // Getters and Setters
    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
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

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }

    // Static method to convert entity to DTO
    public static AnswerRecordDTO fromEntity(UserAnswer answer) {
        AnswerRecordDTO dto = new AnswerRecordDTO();
        dto.setQuestionNumber(answer.getQuestionNumber());
        dto.setQuestionText(answer.getQuestionName());
        dto.setUserAnswer(answer.getPlayerAnswer());
        dto.setCorrectAnswer(answer.getCorrectAnswer());
        dto.setCorrect(answer.isCorrect());
        dto.setQuestionLevel(answer.getQuestionLevel());

        return dto;
    }
}
