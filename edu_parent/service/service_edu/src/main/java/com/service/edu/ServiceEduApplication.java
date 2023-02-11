package com.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceEduApplication
 * @Description TODO
 * @Author hyj98
 * @Date 2023-01-12 11:31
 * @Version 1.0
 */

@SpringBootApplication
@ComponentScan({"com.servicebase","com.service"})
public class ServiceEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class,args);
    }
}
