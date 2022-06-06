package com.nttdata.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.nttdata.bootcamp.models.BusinessCredit;
import com.nttdata.bootcamp.repositories.IBusinessCreditRepo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@EnableEurekaClient
@Slf4j
@SpringBootApplication
public class BootcampServiceProductBusinesscreditsApplication implements CommandLineRunner{

	@Autowired
	IBusinessCreditRepo bcrepo;
	
	@Autowired
	ReactiveMongoTemplate mongoTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BootcampServiceProductBusinesscreditsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		mongoTemplate.dropCollection("businesscredits").subscribe();
		
		Flux.just(BusinessCredit.builder()
				.idCustomerEnterprise("a1")
				.accountingBalance("100")
				.availableBalance("2")
				.build()).flatMap(bs->{
						return bcrepo.save(bs);
				}).subscribe(s-> log.info("Se ingreso businessCredit: "+s));
		
	}

}