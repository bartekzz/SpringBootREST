/**
 * Created by Bartek 2017-12-05
 */

package com.bartek.controller;

import com.bartek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.bartek.service.UserService;

import java.util.Collection;
import java.util.List;

/**
 * This class holds a rest controller that passes on receives request and passes on
 * instructions how to execute them via a user service
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Brings in the userSerivce
     */
    @Autowired
    private UserService userService;

    /**
     * This method gets users from user service and returns them
     * @return a collection of user objects
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers() {

        return userService.getAllUsers();
    }

    /**
     * This method get all users by email from the user service
     * @param email the mail that the user has
     * @return returns list of users
     */
    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public List<User> getAllUsersByEmail(@PathVariable("email") String email) {
        return userService.getAllUsersByEmail(email.replace("_", "."));
    }

    /**
     * This method gets a user with a given id via user service
     * @param id the id of the user
     * @return the user object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    /**
     * This method removes a user with a given id via user service
     * @param id the id of the user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeUserById(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }

    /**
     * This method update the user with a id via user service
     * @param user the user object
     */
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserById(@RequestBody User user) {
        userService.updateUserById(user.getId(), user);
    }

    /**
     * This method insert a new user via user service
     * @param user the user object
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user) {
        userService.insertUser(user);
    }
}
