package com.jonathan.casteriomockito;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserRegistrationTest {

    private  UserRegistration userRegistration;

    private Database mockDatabase;

    private static final String emailAddress = "foo@gmail.com";

    @Before
    public void setup() {
        mockDatabase = mock(Database.class);
        userRegistration = new UserRegistration(mockDatabase);
    }

    @Test(expected = UserAlreadyRegisteredException.class)
    public void shouldThrowExceptionWhenUserAlreadyRegistered() throws UserAlreadyRegisteredException {
        when(mockDatabase.hasUser(anyString())).thenReturn(true);
        userRegistration.registerNewUser(emailAddress);
    }

    @Test
    public void shouldAddNewUserToDatabase() throws UserAlreadyRegisteredException {

        when(mockDatabase.hasUser(emailAddress)).thenReturn(false);

        userRegistration.registerNewUser(emailAddress);

        verify(mockDatabase).addUser(emailAddress);
    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowExceptionWhenTryToDeleteAUserNotFound() throws UserNotFoundException {
        doThrow(UserNotFoundException.class).when(mockDatabase).deleteUser(emailAddress);

        userRegistration.deleteUser(emailAddress);
    }
}