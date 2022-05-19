package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.BusinessCredit;

public interface IBusinessCreditRepo extends ReactiveMongoRepository<BusinessCredit, String>{
	
}
