package com.blogspot.jpdevelopment.mongodb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blogspot.jpdevelopment.mongodb.config.MongoDbConfig;
import com.blogspot.jpdevelopment.mongodb.core.domain.Department;
import com.blogspot.jpdevelopment.mongodb.core.repository.DepartmentRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoDbConfig.class);
		DB db = ctx.getBean(DB.class);

		DBCollection coll = db.getCollection("testCollection");

		BasicDBObject doc = new BasicDBObject("name", "MongoDB").append("type", "database").append("count", 1).append(
				"info", new BasicDBObject("x", 203).append("y", 102));
		coll.insert(doc);

		DBObject myDoc = coll.findOne();
		System.out.println(myDoc);


		DepartmentRepository departmentRepository = ctx.getBean(DepartmentRepository.class);
		departmentRepository.save(new Department("Development"));
		Department storedDepartment = departmentRepository.findOne("Development");
		System.out.println(storedDepartment);
	}


}
