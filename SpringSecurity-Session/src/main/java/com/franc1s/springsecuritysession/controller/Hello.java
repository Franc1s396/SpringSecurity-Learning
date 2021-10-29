package com.franc1s.springsecuritysession.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class Hello {

    @Value("${server.port}")
    public Integer port;

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("name") + ":" + port;
    }

    @GetMapping("/set")
    public String set(HttpSession session){
        session.setAttribute("name","javaBoy");
        return String.valueOf(port);
    }
}
