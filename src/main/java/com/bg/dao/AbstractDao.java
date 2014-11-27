package com.bg.dao;

public interface AbstractDao<T> {
	public static String ARGUMENT_MUST_BE_NOT_NULL = "argument must be not null";
	public void checkNotNull(Object... objectArguments);
}
