/**
 * Created by Bartek 2017-12-07
 */

package com.bartek.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class creates a user object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int id;
    private String email;
    private String name;
    private String password;
    private String key;

    public User() {
    }

    public User(String email, String name, String password, String key) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", key=" + key +
                '}';
    }
}