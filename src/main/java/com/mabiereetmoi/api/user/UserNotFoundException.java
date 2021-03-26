package com.mabiereetmoi.api.user;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String uid) {
        super("User " + uid + " not found");
    }

}
