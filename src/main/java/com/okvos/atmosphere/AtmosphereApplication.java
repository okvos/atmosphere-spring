package com.okvos.atmosphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
public class AtmosphereApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AtmosphereApplication.class, args);
    }

}
