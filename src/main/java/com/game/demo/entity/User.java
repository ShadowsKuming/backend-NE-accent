package com.game.demo.entity;

import jakarta.persistence.*;

/**
 * The User class represents a user in the system and maps to the `game_user` table in the database.
 * This class is designed to collect and store personal information of all individuals who play the game.
 */
@Entity
@Table(name = "game_user")
public class User {

    // Unique identifier for each user (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Username of the player
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    // Education level of the player
    @Column(name = "education_level")
    private String educationLevel;

    // Address of the player
    @Column(name = "current_address")
    private String current_address;

    @Column(name = "long_address")
    private String long_address;

    @Column(name = "child_address")
    private String child_address;

    @Column(name = "postcode")
    private String postcode;

    // Age of the player
    @Column(name = "age")
    private String age;

    // Gender of the player
    @Column(name = "gender")
    private String gender;

    // Indicates whether English is the player's first language
    @Column(name = "is_English_first_language")
    private boolean isEnglishFirstLanguage;

    @Column(name = "first_language")
    private String first_language;

    // No-argument constructor required by JPA
    protected User() {

    }

    public User(String username, String email, String educationLevel, String current_address, String long_address, String child_address, String postcode, String age, String gender, boolean isEnglishFirstLanguage, String first_language) {
        this.username = username;
        this.email = email;
        this.educationLevel = educationLevel;
        this.current_address = current_address;
        this.long_address = long_address;
        this.child_address = child_address;
        this.postcode = postcode;
        this.age = age;
        this.gender = gender;
        this.isEnglishFirstLanguage = isEnglishFirstLanguage;
        this.first_language = first_language;
    }

    // Getters and Setters for each field


    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrent_address() {
        return current_address;
    }

    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
    }

    public String getLong_address() {
        return long_address;
    }

    public void setLong_address(String long_address) {
        this.long_address = long_address;
    }

    public String getChild_address() {
        return child_address;
    }

    public void setChild_address(String child_address) {
        this.child_address = child_address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getFirst_language() {
        return first_language;
    }

    public void setFirst_language(String first_language) {
        this.first_language = first_language;
    }

    public int getId() {
        return id;
    }

    public boolean isEnglishFirstLanguage() {
        return isEnglishFirstLanguage;
    }

    public void setEnglishFirstLanguage(boolean englishFirstLanguage) {
        isEnglishFirstLanguage = englishFirstLanguage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
