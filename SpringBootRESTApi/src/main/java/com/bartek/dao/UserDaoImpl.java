/**
 * Created by Bartek 2017-12-05
 */

package com.bartek.dao;

import com.bartek.apikey.RandomAESKeyGen;
import com.bartek.entity.User;
import com.bartek.exception.UserExistsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * This class is the implementation of the Data Acces Layer interface
 */

@Repository
@Qualifier("UserDaoImpl")
public class UserDaoImpl implements UserDao {


    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * This method gets users from repository (via JPA) and returns them
     * @return list of users
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);

        return users;
    }

    /**
     * This method get all users by email from the repository
     * @param email the email to find
     * @return list of users with given email
     */
    @Override
    public List<User> getAllUsersByEmail(String email) {
        List<User> users = userRepository.findByEmail(email);

        return users;
    }

    /**
     * THis method finds and get the user with a given id from repository
     * @param id the user's id
     * @return the user object
     */
    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    /**
     * This method removes the user with a given id from repository
     * @param id the id of the user
     */
    @Override
    public void removeUserById(Integer id) {
        userRepository.delete(id);
    }

    /**
     * This method updates the user in the repository and hashed the password if is given
     * @param id the id of the user
     * @param user the user object
     */
    @Override
    public void updateUserById(Integer id, User user) {
        if(!user.getPassword().equals("")) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    /**
     * Insert a new user in the repository if it does not exist and encodes password and creates a key
     * @param user the user object
     */
    @Override
    public void insertUser(User user) {
        // Get user with id from Map
        User userExists = null;
        try {
            userExists = getUserById(user.getId());
            System.out.println("User exists: " + userExists);
        }
        catch (JpaObjectRetrievalFailureException e){
            e.printStackTrace();
        }
        finally {

        }
        // If user dont exists generate api key and add to user
        if(userExists == null) {
            try {
                if(!user.getPassword().equals("")) {
                    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                }
                user.setKey(RandomAESKeyGen.generate(256));
                userRepository.save(user);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        // Else output exception
        } else {
            try {
                throw new UserExistsException("Username already taken!");
            } catch (UserExistsException e) {

                System.out.println("Username already taken!");
                System.out.println(userExists.toString());
            }

        }
    }

}
