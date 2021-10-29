package com.franc1s.springsecuritycsrf3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @PostMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/01")
    public String hello2(){
        return "01";
    }
}
