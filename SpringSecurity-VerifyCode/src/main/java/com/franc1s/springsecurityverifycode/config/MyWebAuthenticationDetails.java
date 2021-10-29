package com.franc1s.springsecurityverifycode.config;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class MyWebAuthenticationDetails extends WebAuthenticationDetails {
    private boolean isPassed;

    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        String code =request.getParameter("code");
        String vf= (String) request.getSession().getAttribute("vf");
        if (code==null||vf==null||!code.equals(vf)){

        }
    }
}
