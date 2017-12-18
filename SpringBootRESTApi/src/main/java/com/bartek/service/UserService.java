/**
 * Created by Bartek 2017-12-05
 */

package com.bartek.service;

import com.bartek.dao.UserDao;
import com.bartek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is a user service that uses the Data Access Layer interface and decides
 * via a "qualifier" which implementation si to be used
 */
@Service
public class UserService {

    @Autowired
    @Qualifier("UserDaoImpl")
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<User> getAllUsersByEmail(String email) {
        return userDao.getAllUsersByEmail(email);
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public void removeUserById(Integer id) {
        userDao.removeUserById(id);
    }

    public void updateUserById(Integer id, User user) {
        userDao.updateUserById(id, user);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
