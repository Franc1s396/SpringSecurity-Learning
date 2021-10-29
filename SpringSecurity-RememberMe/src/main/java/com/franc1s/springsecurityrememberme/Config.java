package com.franc1s.springsecurityrememberme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    JdbcTokenRepositoryImpl jdbcTokenRepository(){
        JdbcTokenRepositoryImpl repository=new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        //repository.setCreateTableOnStartup(true);
        return repository;

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("mwc")
                .password("123")
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .rememberMe()
                .tokenRepository(jdbcTokenRepository())
                .and()
                .csrf().disable();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
    }
}
