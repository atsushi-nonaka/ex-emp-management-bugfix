package jp.co.sample.emp_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/", "/toInsert", "/insert", "/login", "/logout", "/employee/**", "/css/**", "/fonts/**", "/js/**", "/img/**").permitAll()
            	.anyRequest().authenticated()
            	.and()
            .formLogin()
            	.loginPage("/")
            	.loginProcessingUrl("/employee/showList")
            	.usernameParameter("mailAddress")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/")
            	.permitAll()
            	.and()
            .logout()
            	.permitAll();
    }
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
	}
	
}	
	
////超上級課題	
////	@Bean
////	@Override
////    public UserDetailsService userDetailsService() {
////		UserDetails user =
////				 User.withDefaultPasswordEncoder()
////				 		.username("user")
////				 		.password("password")
////				 		.roles("USER")
////				 		.build();
////		return new InMemoryUserDetailsManager(user);
////	}
//}
	
