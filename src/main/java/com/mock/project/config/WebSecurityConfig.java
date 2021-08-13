package com.mock.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/resources/**").permitAll()
            	.antMatchers("/*.js").permitAll()
            	.antMatchers("/*.css").permitAll()
            	.antMatchers("/api/**").authenticated()
            	.antMatchers("/main-page").hasAnyRole("ADMIN","TEACHER","STUDENT")
                .antMatchers("/teacherls","/teacherls/{id}/delete","/teacher/register","/teacherls/{id}/edit","/teacher/search","/addclass","/addstudent","/viewstudent","/studentls/{id}/edit","/addtimetable").hasRole("ADMIN")
                .antMatchers("/teacher/editpersonal","/managemarks").hasRole("TEACHER")
                .antMatchers("viewmark","/student/editpersonal").hasRole("STUDENT")
                .and()
            .formLogin()
            	.loginPage("/login")
            	.usernameParameter("email")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/")
            	.failureUrl("/login?error")
            	.and()
        	.exceptionHandling()
    			.accessDeniedPage("/403");
    }
	
}
