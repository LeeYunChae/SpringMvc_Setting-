package com.example.mvcTest.chapter05.execute;

public class CalculatorImpl implements Calculator {
    @Override
    public long factorial(int num){
        long start = System.nanoTime();
        int result =1;
        for(int i=1 ; i<=num;i++){
            result *= i;
        }
        long end = System.nanoTime();
        System.out.println("실행시간 : "+ (end-start)); // 메소드의 실행시간을 구함
        return result;
    }
}
