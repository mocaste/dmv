package com.mocaste.dmv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;


@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DMVServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DMVServiceApplication.class, args);
	}
}
