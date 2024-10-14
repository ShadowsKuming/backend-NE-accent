package com.game.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The UserFormData class is a data transfer object (DTO) that represents the user information
 * received from the front end's personal-info page. This class is used to capture and
 * store the user input fields, which include username, education level, address, age,
 * gender, and whether English is the user's first language. The data is typically
 * sent in JSON format and mapped to this class using Jackson annotations.
 */
public class UserFormData {

    // Fields representing user information received from the frontend
    private String username;
    private String email;
    private String education;
    private String postcode;
    private String current_address;
    private String long_address;
    private String child_address;
    private String age;
    private String gender;
    private String is_English_First_Language;
    private String first_language;

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst_language() {
        return first_language;
    }

    public void setFirst_language(String first_language) {
        this.first_language = first_language;
    }

    public String getIs_English_First_Language() {
        return is_English_First_Language;
    }

    public void setIs_English_First_Language(String is_English_First_Language) {
        this.is_English_First_Language = is_English_First_Language;
    }
}
