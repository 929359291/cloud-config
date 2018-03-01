package com.example.demoeurekaclient;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class DemoEurekaClientApplication {
	private static final  Logger LOG = LoggerFactory.getLogger(DemoEurekaClientApplication.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@GetMapping(value = "/hi")
	public String home(@RequestParam String name, HttpServletRequest request) throws JsonProcessingException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String, Object> map = new HashMap<>();
		map.put("URL", request.getRequestURL());
		map.put("port", request.getServerPort());
		map.put("host", request.getRemoteHost());
		LOG.info("request params:{} date:{} URL:{}", name, sf.format(new Date()), MAPPER.writeValueAsString(map));
		return "hi" + name + ",i am from port:" + port;
	}
}


