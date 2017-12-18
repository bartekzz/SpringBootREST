package com.bartek.dao;

import com.bartek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface makes it possible to use standard method to retrieve data about the object
 * (User object in this case)
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * This method finds the users with an email
     * @param email the email to find
     * @return list of user(s)
     */
    List<User> findByEmail(String email);

}
