package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.BusinessCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessCreditService {
	public Flux<BusinessCredit> findAll();
	public Mono<BusinessCredit> findById(String id);
	public Mono<BusinessCredit> save(BusinessCredit businessCredit);
	public Mono<Void> delete(BusinessCredit businessCredit);
	public Mono<Long> count();
}
