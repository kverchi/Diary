package com.kverchi.diary.custom.exception;

import javax.persistence.PersistenceException;

import com.kverchi.diary.enums.ServiceMessageResponse;

public class DatabaseException extends PersistenceException {

	private static final long serialVersionUID = 1L;
    String msg;
	
	public DatabaseException(Throwable t) {
		super(t);
		this.msg = ServiceMessageResponse.TRANSACTION_PROBLEM.toString();
	}
	public String getMsg() {
		return this.msg;
	}
}
