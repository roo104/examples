package com.blogspot.jpdevelopment.hibernate.proxies;

import static org.junit.Assert.*;

import org.hibernate.proxy.HibernateProxy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogspot.jpdevelopment.hibernate.proxies.config.HsqldbConfig;
import com.blogspot.jpdevelopment.hibernate.proxies.domain.Department;
import com.blogspot.jpdevelopment.hibernate.proxies.domain.Employee;
import com.blogspot.jpdevelopment.hibernate.proxies.repository.DepartmentRepository;
import com.blogspot.jpdevelopment.hibernate.proxies.repository.EmployeeRepository;
import com.blogspot.jpdevelopment.hibernate.proxies.utils.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HsqldbConfig.class})
public class UnproxyTest {

	@Autowired
	private EmployeeRepository classUnderTest;
	@Autowired
	private DepartmentRepository departmentRepository;

	private Department department;

	@Before
	public void setup() {
		this.department = this.departmentRepository.save(new Department("Development"));
	}

	@Test
	public void testUnproxy() {
		Employee savedEmployee = this.classUnderTest.save(new Employee("Jonas", "Developer", this.department));

		// First verify returned object is a HibernateProxy
		assertTrue(savedEmployee.getDepartment() instanceof HibernateProxy);

		HibernateUtil.unproxy(savedEmployee);

		// After unproxied, verify it's no longer a proxy
		assertTrue(savedEmployee.getDepartment() instanceof Department);
	}

}
