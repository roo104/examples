package com.blogspot.jpdevelopment.spring.rest.core.rest.controller;

import com.blogspot.jpdevelopment.mongodb.config.MongoDbConfig;
import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import com.blogspot.jpdevelopment.mongodb.core.repository.PersonRepository;
import com.blogspot.jpdevelopment.spring.rest.config.RestConfig;
import org.junit.Before;
import org.junit.Ignore;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(classes = {RestConfig.class, MongoDbConfig.class})
public class PersonControllerTest {

	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private PersonRepository personRepository;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Ignore
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

	@Ignore
	@Test
	public void getPerson() throws Exception {
		// Insert a new person behind the REST service
		Person person = this.personRepository.save(new Person("Jonas", "Developer", null));

		ResultActions resultActions = this.mockMvc.perform(get("/rest/persons/" + person.getId()).accept(
				MediaType.APPLICATION_JSON));

		resultActions.andDo(print()).andExpect(status().isOk());
		resultActions.andExpect(jsonPath("$.id").value(person.getId().toString()));
		resultActions.andExpect(jsonPath("$.name").value("Jonas"));
		resultActions.andExpect(jsonPath("$.title").value("Developer"));
	}

	@Ignore
	@Test
	public void getPersonNoPersonFound() throws Exception {
		// Lookup a person with given a UUID. Yes it will fail once every 1000 year, but that's OK for now :)
		ResultActions resultActions = this.mockMvc.perform(get("/rest/persons/38400000-8cf0-11bd-b23e-10b96e4ef00d").accept(
				MediaType.APPLICATION_JSON));

		resultActions.andDo(print()).andExpect(status().isNoContent());
		resultActions.andExpect(jsonPath("$.message").value("No person with ID [38400000-8cf0-11bd-b23e-10b96e4ef00d] found"));
		resultActions.andExpect(jsonPath("$.resource").value("uri=/rest/persons/38400000-8cf0-11bd-b23e-10b96e4ef00d"));
	}

}
