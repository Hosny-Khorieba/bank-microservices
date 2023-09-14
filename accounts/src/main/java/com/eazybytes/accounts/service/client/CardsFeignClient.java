package com.eazybytes.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.eazybytes.accounts.model.Cards;
import com.eazybytes.accounts.model.Customer;

@FeignClient("cards")
public interface CardsFeignClient {
	
	@PostMapping(value = "myCards", consumes = "application/json")
	List<Cards> getListOfCards(@RequestBody Customer customer);
}
