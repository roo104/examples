package com.blogspot.jpdevelopment.spring.rest.core.domain.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.blogspot.jpdevelopment.mongodb.config.MongoDbConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.blogspot.jpdevelopment.spring.rest.configuration.RestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(classes = {RestConfig.class, MongoDbConfig.class})
public class PersonControllerTest {

	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void addPerson() throws Exception {
		ResultActions resultActions = this.mockMvc.perform(post("/rest/persons").content(
				"{\"name\":\"Jonas\",\"title\":\"Developer\"}").contentType(MediaType.APPLICATION_JSON).accept(
				MediaType.APPLICATION_JSON));

		resultActions.andDo(print()).andExpect(status().isCreated());
		resultActions.andExpect(jsonPath("$.id").exists());
		resultActions.andExpect(jsonPath("$.name").value("Jonas"));
		resultActions.andExpect(jsonPath("$.title").value("Developer"));
	}

}
