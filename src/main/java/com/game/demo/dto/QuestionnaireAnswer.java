package com.game.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionnaireAnswer {

    private int id;

    @JsonProperty("attended_event")
    private String attendedEvent;

    @JsonProperty("learned_something")
    private String learnedSomething;

    @JsonProperty("venue_use")
    private String venueUse;

    @JsonProperty("learned_new")
    private String learnedNew;

    @JsonProperty("enjoyed_most_least")
    private String enjoyedMostOrLeast;

    @JsonProperty("changed_views")
    private String changedViews;

    @JsonProperty("comments_feedback")
    private String commentsFeedback;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttendedEvent() {
        return attendedEvent;
    }

    public void setAttendedEvent(String attendedEvent) {
        this.attendedEvent = attendedEvent;
    }

    public String getLearnedSomething() {
        return learnedSomething;
    }

    public void setLearnedSomething(String learnedSomething) {
        this.learnedSomething = learnedSomething;
    }

    public String getVenueUse() {
        return venueUse;
    }

    public void setVenueUse(String venueUse) {
        this.venueUse = venueUse;
    }

    public String getLearnedNew() {
        return learnedNew;
    }

    public void setLearnedNew(String learnedNew) {
        this.learnedNew = learnedNew;
    }

    public String getEnjoyedMostOrLeast() {
        return enjoyedMostOrLeast;
    }

    public void setEnjoyedMostOrLeast(String enjoyedMostOrLeast) {
        this.enjoyedMostOrLeast = enjoyedMostOrLeast;
    }

    public String getChangedViews() {
        return changedViews;
    }

    public void setChangedViews(String changedViews) {
        this.changedViews = changedViews;
    }

    public String getCommentsFeedback() {
        return commentsFeedback;
    }

    public void setCommentsFeedback(String commentsFeedback) {
        this.commentsFeedback = commentsFeedback;
    }
}
