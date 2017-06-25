package com.jonathan.casteriomockito;

public class UserRegistration {

    private Database database;

    public UserRegistration(Database database) {
        this.database = database;
    }

    public void registerNewUser(String emailAddress) throws UserAlreadyRegisteredException {
        if (database.hasUser(emailAddress)) {
            throw new UserAlreadyRegisteredException();
        }
        database.addUser(emailAddress);
    }

    public void deleteUser(final String emailAddress) throws UserNotFoundException {
        if(!database.hasUser(emailAddress)) {
            throw new UserNotFoundException();
        }
        database.deleteUser(emailAddress);
    }
}
