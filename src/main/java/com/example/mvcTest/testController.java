package com.example.mvcTest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class testController {
    @GetMapping("/hello")
    public String test(){
        return "testController";
    }

    @GetMapping("/test09")
    @ResponseBody//응답을 담는 값
    public MemberVo[] test09(){
        MemberVo vo = new MemberVo();
        vo.setId("hong");
        vo.setPwd("1234");
        MemberVo[] arr = {vo,vo,vo};
        //  Map<String, Object> map = new HashMap<>(); map으로도 담을 수 있음

        return arr;
    }


}
