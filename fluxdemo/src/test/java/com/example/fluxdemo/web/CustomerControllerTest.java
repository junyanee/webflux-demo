package com.example.fluxdemo.web;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.fluxdemo.domain.Customer;
import com.example.fluxdemo.domain.CustomerRepository;

import reactor.core.publisher.Mono;

// 통합테스트
// @SpringBootTest
// @AutoConfigureWebTestClient


@WebFluxTest

public class CustomerControllerTest {


	@MockBean
	private CustomerRepository customerRepository;

	@Autowired
	private WebTestClient webClient;

	@Test
	public void test_findOne() {

		// given
		Mono<Customer> givenData = Mono.just(new Customer("Jack", "Bauer"));

		// stub -> 행동 지시
		when(customerRepository.findById(1L)).thenReturn(givenData);

		webClient.get().uri("/customer/{id}", 1L)
		.exchange()
		.expectBody()
		.jsonPath("$.firstName").isEqualTo("Jack")
		.jsonPath("$.lastname").isEqualTo("Bauer");
	}
}
