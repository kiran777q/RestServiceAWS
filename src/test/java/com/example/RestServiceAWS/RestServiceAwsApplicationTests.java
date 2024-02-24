package com.example.RestServiceAWS;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RestServiceAwsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetRequest() throws Exception {
		String name = "Kiran";
		String expectedResponse = "I am Changing My Name to SHIV"; // Replace with the expected response

		mockMvc.perform(MockMvcRequestBuilders.get("/TestApp")
						.param("Name", name))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(expectedResponse));
	}
}