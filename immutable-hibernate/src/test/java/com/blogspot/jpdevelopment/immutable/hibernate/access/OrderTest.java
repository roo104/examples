package com.blogspot.jpdevelopment.immutable.hibernate.access;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogspot.jpdevelopment.immutable.hibernate.configuration.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class OrderTest {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Before
	public void setup() {
		this.session = this.sessionFactory.openSession();
	}

	@Test
	public void persist() {
		Order accessOrder = Order.createOrder();
		this.session.persist(accessOrder);

		Order resultOrder = (Order) this.session.get(Order.class, accessOrder.getOrderId());
		assertNotNull(resultOrder);
	}

}
