package com.example.fluxdemo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import com.example.fluxdemo.DBinit;

import reactor.test.StepVerifier;


@DataR2dbcTest
@Import(DBinit.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void test_findOne() {
		StepVerifier
		.create(customerRepository.findById(2L))
		.expectNextMatches((c) -> {
			return c.getFirstName().equals("Chloe");
		})
		.expectComplete()
		.verify();
	}
}
