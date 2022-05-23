package com.nttdata.bootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.models.BusinessCredit;
import com.nttdata.bootcamp.repositories.IBusinessCreditRepo;
import com.nttdata.bootcamp.services.IBusinessCreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessCreditImpl implements IBusinessCreditService {
	
	@Autowired
	IBusinessCreditRepo bcrepo;
	

	@Override
	public Flux<BusinessCredit> findAll() {
		return bcrepo.findAll();
	}

	@Override
	public Mono<BusinessCredit> findById(String id) {
		return bcrepo.findById(id);
	}

	@Override
	public Mono<BusinessCredit> save(BusinessCredit businessCredit) {
		return bcrepo.save(businessCredit);
	}

	@Override
	public Mono<Void> delete(BusinessCredit businessCredit) {
		return bcrepo.delete(businessCredit);
	}

	@Override
	public Mono<Long> count() {
		return bcrepo.count();
	}

}
