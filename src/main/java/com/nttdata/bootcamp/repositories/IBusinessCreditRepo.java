package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.BusinessCredit;

import reactor.core.publisher.Flux;

public interface IBusinessCreditRepo extends ReactiveMongoRepository<BusinessCredit, String>{

	Flux<BusinessCredit> findByIdCustomerEnterprise(String idCustomer);
	
}