/**
 * Created by Bartek 2017-12-07
 */

package com.bartek.service;

import com.bartek.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestOperations;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestService {

    public String test = "Im a test";

    @Autowired
    private RestOperations restOperations;

    public User getUserById(int id) {
        User user = restOperations.getForObject("http://localhost:8080/users/" + id, User.class);

        return user;
    }

    public List<User> getAllUsers() {

        ResponseEntity<User[]> responseEntity = restOperations.getForEntity("http://localhost:8080/users", User[].class);
        User[] objects = responseEntity.getBody();
        System.out.println("User: " + objects);

        return Arrays.asList(objects);
    }

    public List<User> getAllUsersByEmail(String email) throws UnsupportedEncodingException {

        System.out.println("Email Restservice: " + email);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<>();
        params.put("email", email);

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity<User[]> responseEntity = restOperations.exchange("http://localhost:8080/users/email/" + email.replace(".", "_"), HttpMethod.GET, entity, User[].class, params);

        //ResponseEntity<User[]> responseEntity = restOperations.getForEntity("http://localhost:8080/users", User[].class);
        User[] objects = responseEntity.getBody();
        System.out.println("User: " + objects);

        return Arrays.asList(objects);
    }

    public void removeUserById(int id) {
        restOperations.delete("http://localhost:8080/users/" + id);
    }

    public void insertUser(User user) {

        HttpEntity<User> request = new HttpEntity<>(user);
        restOperations.postForObject("http://localhost:8080/users", request, User.class);

    }


    public void updateUserById(@RequestBody User user) {

        HttpEntity<User> request = new HttpEntity<>(user);
        restOperations.put("http://localhost:8080/users", request, User.class);
    }

}
