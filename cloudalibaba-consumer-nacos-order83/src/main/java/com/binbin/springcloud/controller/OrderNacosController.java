package com.binbin.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server-url.nacos-user-service")
    private String serverUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") long id){
        return  restTemplate.getForObject(serverUrl + "/payment/nacos/"+id,String.class);
    }

}
