package com.flhub.ideams.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import com.flhub.ideams.filter.JwtFilter;

import com.flhub.ideams.Services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomLoginSuccessHandler successHandler;

    @Autowired
    private JwtFilter jwtFilter;

    // @Autowired
    // UserDetailsServiceImpl userDetailsService;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserDetailsServiceImpl userDetailsService() {
    return new UserDetailsServiceImpl();
    }

    // @Bean
    // public BCryptPasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {
    // DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    // authProvider.setUserDetailsService(userDetailsService());
    // authProvider.setPasswordEncoder(passwordEncoder());
    //
    // return authProvider;
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.authenticationProvider(authenticationProvider());
    // }

    // @Value("${security.enable-csrf}")
    // private boolean csrfEnabled;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.authorizeRequests()
        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/authenticate").permitAll()
        .anyRequest().authenticated()
         
                // .antMatchers("/api/ideas**","/api/users**","/register", "/save", "/login", "/welcome", "/", "/addnote", "/notes").permitAll()
                // .antMatchers("/users", "/search", "searchresult").permitAll()
                // .antMatchers("/", "/resources/**", "/css/**", "/fonts**", "/img/**", "/js/**", "/assets/**").permitAll()
                // .antMatchers("/home", "/addgender", "/gender", "/genders", "/addcountry", "/addrole", "/welcome","/userss").permitAll()
                // .antMatchers("/register", "/userhome").permitAll()
                // .antMatchers("/user/{globalUserId}", "/createuser**","/api/ideas/submit").permitAll()
                // .antMatchers("/idea", "/createIdea**", "/page/{pageNo}", "/pageNo", "/page/{pageNo2}").permitAll()
                // .antMatchers("/seeideas", "/seeideas/idea/{ideaId}", "/seeusers", "/file", "/files/{filename:.+}").permitAll()
                // .antMatchers("/delete/{ideaId}", "/edit/{ideaId}", "/editt/{globalUserId}", "/comment/{ideaId}").permitAll()
                // .antMatchers("/admin").hasAnyAuthority("ADMIN")
                // .antMatchers("/user", "/createIdea**", "/idea", "/ideas").hasAnyAuthority("USER")
                // .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
                // .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
            //     .antMatchers("/delete/**").hasAuthority("ADMIN")
            //     .anyRequest().authenticated()
                
            //   //  .and()
            //     .formLogin()
            //     .loginPage("/login").permitAll()
            //     .successHandler(successHandler)
            //     .and().logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
               

        // CORS configuration

        // This value must be parameterized according to your application needs
        final String corsOrigin = "http://localhost:3001";
        // The idea is to insert the CORS filter before the filter injected by
        // the @EnableOAuth2Sso annotation
        http.addFilterBefore(new CorsFilter(corsConfigurationSource(corsOrigin)),
                AbstractPreAuthenticatedProcessingFilter.class);
    }

    private CorsConfigurationSource corsConfigurationSource(String corsOrigin) {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(corsOrigin));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "HEAD", "OPTIONS", "PUT", "PATCH", "DELETE"));
        configuration.setMaxAge(10L);
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(
                Arrays.asList("Accept", "Access-Control-Request-Method", "Access-Control-Request-Headers",
                        "Accept-Language", "Authorization", "Content-Type", "Request-Name", "Request-Surname", "Origin",
                        "X-Request-AppVersion", "X-Request-OsVersion", "X-Request-Device", "X-Requested-With"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

        // super.configure(http);
        //
        // if(!csrfEnabled)
        // {
        // http.csrf().disable();
        // }
    }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // The configuration that you needed

    // If preflight requests are redirected by OAuth conf, you can try adding:
    // .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

    // CORS configuration

}
