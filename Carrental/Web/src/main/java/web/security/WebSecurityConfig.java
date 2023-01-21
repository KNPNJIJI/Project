package web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = {"web"})
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/car*").permitAll()
                .antMatchers("/index*").permitAll()
                .antMatchers("/model/*").permitAll()
                .antMatchers("/api/*").permitAll()
                .antMatchers("/image/*").permitAll()
                .antMatchers( "/admin-console*").hasRole("ADMIN")
                .antMatchers( "/admin-console*").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/delete*").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/list*").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth,
                                        @Qualifier("authService") AuthenticationService service) throws Exception {
        auth.userDetailsService(service);
    }
}
