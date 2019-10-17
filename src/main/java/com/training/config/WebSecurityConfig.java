package com.training.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "userDetailService")
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().anyRequest().hasAnyRole("ADMIN",
	 * "USER").and().authorizeRequests() .antMatchers("/resources/**",
	 * "/css/**").permitAll().antMatchers("/customer/registration/**")
	 * .permitAll().antMatchers("/login**").permitAll().and().formLogin().loginPage(
	 * "/login")
	 * .loginProcessingUrl("/loginAction").defaultSuccessUrl("/dashboard").permitAll
	 * ().and().logout()
	 * .logoutSuccessUrl("/login").permitAll().and().csrf().disable(); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/resources/**", "/forgotPass/**").permitAll()
				.antMatchers("/resources/**", "/customer/registration/**","/customer/register/**").permitAll()
				.antMatchers("/resources/**", "/data/**").permitAll().antMatchers("/actuator/*").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN", "USER").anyRequest().authenticated().and().formLogin()
				.loginPage("/login").loginProcessingUrl("/loginAction").defaultSuccessUrl("/dashboard", true)
				.failureUrl("/login?error=1").permitAll().and().logout().permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}
