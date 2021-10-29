package com.franc1s.springsecurityverifycode.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class Hello {

    @Autowired
    private Producer producer;

    @GetMapping("/vf")
    public void getVerifyCode(HttpServletResponse response, HttpSession session){
        response.setContentType("image/jpeg");
        String text=producer.createText();
        session.setAttribute("vf",text);
        BufferedImage image = producer.createImage(text);
        try (ServletOutputStream out=response.getOutputStream()){
            ImageIO.write(image,"jpg",out);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/user")
    public String user(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "123";
    }
}
