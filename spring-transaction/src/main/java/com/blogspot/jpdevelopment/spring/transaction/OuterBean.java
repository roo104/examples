package com.blogspot.jpdevelopment.spring.transaction;

import com.blogspot.jpdevelopment.spring.transaction.model.User;

public interface OuterBean {

	void testRequired(User user);
	
	void testRequiresNew(User user);

}
