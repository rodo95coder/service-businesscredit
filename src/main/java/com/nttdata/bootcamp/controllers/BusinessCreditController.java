package com.nttdata.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.models.BusinessCredit;
import com.nttdata.bootcamp.services.IBusinessCreditService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/businessCredit")
public class BusinessCreditController {
	
	@Autowired
	private IBusinessCreditService bcrepo;
	
	@GetMapping("/findAll")
	public Flux<BusinessCredit> findAll(){
		log.info("all BusinessCredit were consulted");
		return bcrepo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Mono<BusinessCredit> findById(@PathVariable String id){
		log.info("a BusinessCredit was consulted by id");
		return bcrepo.findById(id);
	}
	
	@PutMapping("/update")
	public Mono<BusinessCredit> update(@RequestBody BusinessCredit businessCredit){
		return bcrepo.findById(businessCredit.getId()).flatMap(b->{
			b.setAccountingBalance(businessCredit.getAccountingBalance());
			b.setAvailableBalance(businessCredit.getAvailableBalance());
			log.info("a BusinessCredit was updated");
			return bcrepo.save(b);
		});
	}
	
	@PostMapping("/save")
	public Mono<BusinessCredit> save(@RequestBody BusinessCredit businessCredit){
		log.info("a BusinessCredit was created");
		return bcrepo.save(businessCredit);
	}
	
	@DeleteMapping("/delete")
	public Mono<Void> delete(@RequestBody BusinessCredit businessCredit){
		log.info("a BusinessCredit was deleted");
		return bcrepo.delete(businessCredit);
	}

}
