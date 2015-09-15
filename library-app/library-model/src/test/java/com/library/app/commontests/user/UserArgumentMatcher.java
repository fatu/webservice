package com.library.app.commontests.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;

import org.mockito.ArgumentMatcher;

import com.library.app.user.model.User;

public class UserArgumentMatcher extends ArgumentMatcher<User> {
	private User expectedUser;

	public static User userEq(final User expectedUser) {
		return argThat(new UserArgumentMatcher(expectedUser));
	}

	public UserArgumentMatcher(final User expectedUser) {
		this.expectedUser = expectedUser;
	}

	@Override
	public boolean matches(final Object argument) {
		final User actualUser = (User) argument;

		assertThat(actualUser.getId(), is(equalTo(expectedUser.getId())));
		assertThat(actualUser.getName(), is(equalTo(expectedUser.getName())));
		assertThat(actualUser.getEmail(), is(equalTo(expectedUser.getEmail())));
		assertThat(actualUser.getPassword(), is(equalTo(expectedUser.getPassword())));

		return true;
	}

}