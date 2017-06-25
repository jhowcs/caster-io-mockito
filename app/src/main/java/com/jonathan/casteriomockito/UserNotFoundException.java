package com.jonathan.casteriomockito;

/**
 * Created by jonathan on 6/25/17.
 */

public class UserNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "User not found!";
    }
}
