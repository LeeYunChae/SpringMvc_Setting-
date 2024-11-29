package com.example.mvcTest.chapter05.config;

import com.example.mvcTest.chapter05.execute.Calculator;
import com.example.mvcTest.chapter05.execute.CalculatorImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Beans {
    @Bean
    public Calculator calc(){
        return new CalculatorImpl2(); // 얘를 읽을 때 컨테이너 생성
        }
    }

