package com.jonathan.casteriomockito;

class UserAlreadyRegisteredException extends Exception {

    @Override
    public String getMessage() {
        return "The user has already registered!";
    }
}
