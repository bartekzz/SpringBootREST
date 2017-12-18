/**
 * Created by Bartek 2017-12-05
 */
package com.bartek.exception;

/**
 * Custom exeption class if user exists
 */
public class UserExistsException extends Exception {

    public UserExistsException(String message) {

        super(message);
    }
}
