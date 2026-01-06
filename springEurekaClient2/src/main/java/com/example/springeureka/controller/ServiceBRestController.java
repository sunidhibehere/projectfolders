package com.example.springeureka.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class ServiceBRestController {
	private final DiscoveryClient discoveryClient;
	private final RestClient restClient;
	
	public ServiceBRestController(DiscoveryClient discoveryClient,RestClient.Builder restClientBuilder) {
		this.discoveryClient=discoveryClient;
		restClient = restClientBuilder.build();
	}
	
	@GetMapping("/helloEureka")
	public String helloWorld() {
		List<ServiceInstance> instances = discoveryClient.getInstances("servicea");
		if(instances.isEmpty()) {
			return "Service A is not available";
		}
		ServiceInstance serviceInstance = instances.get(0);
		return restClient.get().uri(serviceInstance.getUri()+"/helloworld").retrieve().body(String.class);
		}
}
