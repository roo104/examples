package com.blogspot.jpdevelopment.hibernate.proxies.utils;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

public class HibernateUtil {

	public static <T> T unproxy(T proxied) {
		T entity = proxied;
		if (entity != null && entity instanceof HibernateProxy) {
			Hibernate.initialize(entity);
			entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
		}
		return entity;
	}
}
