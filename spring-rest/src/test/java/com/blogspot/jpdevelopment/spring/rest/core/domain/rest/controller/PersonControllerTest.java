package com.blogspot.jpdevelopment.spring.rest.core.domain.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
@ContextConfiguration(classes = {RestConfig.class})
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
				"{\"firstname\":\"J\",\"lastname\":\"P\"}").contentType(MediaType.APPLICATION_JSON).accept(
				MediaType.APPLICATION_JSON));

		resultActions.andDo(print()).andExpect(status().isCreated());
		resultActions.andExpect(jsonPath("$.firstname").value("J"));
		resultActions.andExpect(jsonPath("$.lastname").value("P"));
	}

}
