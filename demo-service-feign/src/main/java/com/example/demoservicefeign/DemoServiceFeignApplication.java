package com.example.demoservicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableHystrixDashboard
@SpringCloudApplication
public class DemoServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceFeignApplication.class, args);
	}
}
