/**
 * Created by Bartek 2017-12-07
 */

package com.bartek.controller;

import com.bartek.model.User;
import com.bartek.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * This class implements a Spring rest controller that is being called by user action through AngularJS
 */
@RestController
public class AngularController {

    @Autowired
    RestService restService;

    /**
     * This method gets all users from via RestService
     * @return returns a list of users
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {

        return restService.getAllUsers();
    }

    /**
     *
     * @param email that is used to find specific user(s)
     * @return list of users that has the email
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/all/email/{email}", method = RequestMethod.GET)
    public List<User> getAllUsersByEmail(@PathVariable("email") String email) throws UnsupportedEncodingException {
        System.out.println("Email AngController: " + email);
        return restService.getAllUsersByEmail(email);
    }

    /**
     * Posts user object via RestService
     * @param user user object to post
     */
    @RequestMapping(value = "/post-user", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user) {

        restService.insertUser(user);
    }

    /**
     * Update users object via RestService
     * @param user the user object to update
     */
    @RequestMapping(value = "/put-user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {

        restService.updateUserById(user);

    }

    /**
     * Delete user via RestService
     * @param id the user id of the user to delete
     */
    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.POST)
    public void removeUserById(@PathVariable("id") Integer id) {

        restService.removeUserById(id);

    }

}
