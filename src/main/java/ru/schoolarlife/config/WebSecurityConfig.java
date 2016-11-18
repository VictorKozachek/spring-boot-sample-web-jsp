package ru.schoolarlife.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author victor
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select email, password, 'true' from user where email=?");
        // TODO: Victor design this
        //         .usersByUsernameQuery("select email, password, enabled from user where email=?");
        //         .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/security/register").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("/main").access("hasRole('ROLE_PARENT')").anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/security/login").usernameParameter("email").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/security/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/security/403")
                .and()
                .csrf();
    }

 /*   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }*/
}
