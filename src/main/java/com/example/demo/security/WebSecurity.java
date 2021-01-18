package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

/* @Resource(name="UserService")
private UserDetailsService userService;

@Autowired
public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(userService).passwordEncoder(encoder());
}

public BCryptPasswordEncoder encoder() {
return new BCryptPasswordEncoder();
}*/

@Override
public void configure(HttpSecurity http) throws Exception {
http.cors();
http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
/*.csrf()
.disable()
.authorizeRequests()
.antMatchers("/getPassword/**").permitAll()
//.antMatchers("/api/v1/employee/**").permitAll()
.antMatchers("/users/**").access("hasRole('ADMIN')")
//.antMatchers("/login").access("hasRole('USER') or hasRole('ADMIN')")
.and()
.formLogin().defaultSuccessUrl("/home")
.and()
.logout().logoutSuccessUrl("/logout");*/
}
}

