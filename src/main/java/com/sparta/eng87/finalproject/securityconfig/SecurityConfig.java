package com.sparta.eng87.finalproject.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public SecurityConfig(DataSource dataSource, BCryptPasswordEncoder encoder) {
        this.dataSource = dataSource;
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_name,user_password,user_enabled from user_entity where user_name=?")
                .authoritiesByUsernameQuery("select user_name,user_role from user_entity where user_name=?")
                .passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // This part configures what roles can access which pages
        http.authorizeRequests()
                .antMatchers("/**").authenticated()
                .anyRequest().authenticated()

                // This part configures where to send user that logs in successfully
                .and().formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true)

                // handles logging out
                .and().logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies());
    }
}
