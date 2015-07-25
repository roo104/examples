package com.blogspot.jpdevelopment.spring.transaction.dao;

import com.blogspot.jpdevelopment.spring.transaction.model.User;

public interface TestDAO {

	void insertUser(User user);

	User fetchUser(int id);

}
