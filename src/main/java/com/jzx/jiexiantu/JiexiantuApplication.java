package com.jzx.jiexiantu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.jzx.jiexiantu.mapper")
public class JiexiantuApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiexiantuApplication.class, args);
    }

}
