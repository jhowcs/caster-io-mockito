package com.jonathan.casteriomockito;


public interface Database {

    boolean hasUser(String emailAddress);
    void addUser(String emailAddress);
    void deleteUser(String emailAddress);
}
