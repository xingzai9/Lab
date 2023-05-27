package com.example.labreservesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 800) //800秒过期时间
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30 * 60)
@SpringBootApplication
@MapperScan(value = "com.example.labreservesystem.mapper")
public class LabReserveSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabReserveSystemApplication.class, args);
    }

}
