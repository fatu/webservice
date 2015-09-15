package com.library.app.user.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {
	private static final long serialVersionUID = -6100894877953675646L;

	public Customer() {
		setUserType(UserType.CUSTOMER);
	}

	@Override
	protected List<Roles> getDefaultRoles() {
		return Arrays.asList(Roles.CUSTOMER);
	}

}