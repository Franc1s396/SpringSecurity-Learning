package com.franc1s.springsecuritycsrf.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/transfer")
    public void transferMoney(String username,Double money){
        System.out.println(username);
        System.out.println("money=>"+money);
    }
}
