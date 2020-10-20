package com.kenez92;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class AspectApplication {
    public static void main(String[] args) {
        SpringApplication.run(AspectApplication.class, args);
    }

}
