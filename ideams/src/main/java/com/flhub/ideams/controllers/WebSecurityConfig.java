package com.flhub.ideams.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.flhub.ideams.Services.UserDetailsServiceImpl;


 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	CustomLoginSuccessHandler successHandler;
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
    @Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
   }
     
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//         
//        return authProvider;
//    }
 
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
    
//    @Value("${security.enable-csrf}")
//	private boolean csrfEnabled;
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/register","/save","/login","/welcome","/","/addnote","/notes").permitAll()
            .antMatchers("/users","/search","searchresult").permitAll()
		    .antMatchers("/","/resources/**","/css/**","/fonts**","/img/**","/js/**","/assets/**").permitAll()
		    .antMatchers("/home","/addgender","/gender","/genders","/addcountry", "/addrole","/welcome", "/userss").permitAll()
		    .antMatchers("/register","/userhome").permitAll()
		    .antMatchers("/user/{globalUserId}","/createuser**").permitAll()
		    .antMatchers("/idea", "/createIdea**","/page/{pageNo}","/pageNo","/page/{pageNo2}").permitAll()
		    .antMatchers("/seeideas","/seeideas/idea/{ideaId}","/seeusers","/file","/files/{filename:.+}").permitAll()
		    .antMatchers("/delete/{ideaId}","/edit/{ideaId}","/editt/{globalUserId}","/comment/{ideaId}").permitAll()
            .antMatchers("/admin").hasAnyAuthority("ADMIN")
            .antMatchers("/user","/createIdea**","/idea","/ideas").hasAnyAuthority("USER")
            .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
            .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
            .antMatchers("/delete/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login").permitAll()
            .successHandler(successHandler)
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;
        
//        super.configure(http);
//
// 	   if(!csrfEnabled)
// 	   {
// 		   http.csrf().disable();
// 	   }
    }
}
