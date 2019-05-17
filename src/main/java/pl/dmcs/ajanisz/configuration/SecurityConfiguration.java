package pl.dmcs.ajanisz.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("null").password("{noop}null").roles("USER");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
    .antMatchers("/appUsers*").access("hasRole('ADMIN')")
                .and().formLogin().loginPage("/login").permitAll()
                .usernameParameter("login").passwordParameter("password")
                .failureForwardUrl("/login.html?error")
                .and().logout().logoutSuccessUrl("/login.html?logout")
                .and().exceptionHandling().accessDeniedPage("/accessDenied");

    }
}
