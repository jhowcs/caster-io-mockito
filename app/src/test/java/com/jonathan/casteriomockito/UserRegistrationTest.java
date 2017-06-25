package com.jonathan.casteriomockito;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRegistrationTest {

    private  UserRegistration userRegistration;

    private Database mockDatabase;

    @Before
    public void setup() {
        mockDatabase = mock(Database.class);
        userRegistration = new UserRegistration(mockDatabase);
    }

    @Test(expected = UserAlreadyRegisteredException.class)
    public void shouldThrowExceptionWhenUserAlreadyRegistered() throws UserAlreadyRegisteredException {
        when(mockDatabase.hasUser(anyString())).thenReturn(true);
        userRegistration.registerNewUser("foo@gmail.com");
    }
}