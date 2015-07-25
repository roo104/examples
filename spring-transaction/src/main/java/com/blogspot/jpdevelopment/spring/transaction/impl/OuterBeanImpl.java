package com.blogspot.jpdevelopment.spring.transaction.impl;

import com.blogspot.jpdevelopment.spring.transaction.InnerBean;
import com.blogspot.jpdevelopment.spring.transaction.OuterBean;
import com.blogspot.jpdevelopment.spring.transaction.dao.TestDAO;
import com.blogspot.jpdevelopment.spring.transaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OuterBeanImpl implements OuterBean {

	@Autowired
	private TestDAO testDAO;
	
	@Autowired
	private InnerBean innerBean;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequired(User user) {
        this.testDAO.insertUser(user);
		try{
            this.innerBean.testRequired();
		} catch(RuntimeException e){
			// handle exception
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequiresNew(User user) {
        this.testDAO.insertUser(user);
		try{
            this.innerBean.testRequiresNew();
		} catch(Exception e){
			// handle exception
		}
	}

}
