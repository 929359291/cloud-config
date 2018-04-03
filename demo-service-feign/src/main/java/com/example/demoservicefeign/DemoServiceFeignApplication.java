package com.example.demoservicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients
@EnableHystrixDashboard
@SpringCloudApplication
@EnableHystrix
@EnableCircuitBreaker
public class DemoServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceFeignApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	/*针对spring boot 2.0和spring cloud Finchley.M8这类的版本出现Unable to connect to Command Metric Stream。是因为，默认其实的切入点是：/actuator/hystrix.stream。要改成/hystrix.stream：
			[plain] view plain copy
	management:
	endpoints:
	web:
	exposure:
	include: "*"
	base-path: /*/

}
