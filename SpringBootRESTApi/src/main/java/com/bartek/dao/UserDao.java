/**
 * Created by Bartek 2017-12-05
 */

package com.bartek.dao;

import com.bartek.entity.User;
import java.util.List;

/**
 * This interface is the Data Access Layer
 */
public interface UserDao {

    List<User> getAllUsers();

    List<User> getAllUsersByEmail(String email);

    User getUserById(Integer id);

    void removeUserById(Integer id);

    void updateUserById(Integer id, User user);

    void insertUser(User user);

}
