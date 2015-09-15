package com.library.app.user.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class UserExistentException extends RuntimeException {
	private static final long serialVersionUID = 8706762471635372429L;

}