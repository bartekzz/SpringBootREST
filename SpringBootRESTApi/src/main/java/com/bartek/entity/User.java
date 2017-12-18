package com.bartek.entity;

import javax.persistence.*;

/**
 * This class creates a user and persist it in the DB
 */
@Entity
@Table(name="userTable")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String name;
    private String password;
    @Column(name="user_key")
    private String key;

    public User() {
    }

    public User(String email, String name, String password, String key) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.key = key;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
