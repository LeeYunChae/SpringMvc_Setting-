package com.example.mvcTest.chapter05.execute;
//재귀호출로
public class CalculatorImpl2 implements Calculator {
    @Override
    public long factorial(int num){
        if(num==0){
            return 1;
        }
       // factorial()
        return num * factorial(num-1);
    }
}
