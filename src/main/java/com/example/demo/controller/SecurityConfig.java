package com.example.demo.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//hadi pour securiser mais j'ai un probleme de compatibilite
@Configuration
@EnableWebSecurity
public class SecurityConfig {/*extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // Accès public
                .antMatchers("/secure/**").authenticated() // Accès sécurisé
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // Page de connexion personnalisée
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }*/
}
