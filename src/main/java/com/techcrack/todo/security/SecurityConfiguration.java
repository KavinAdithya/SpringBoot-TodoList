package com.techcrack.todo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
	
//	@Bean
//	public InMemoryUserDetailsManager manageUserDetails() {
//		@SuppressWarnings("deprecation")
//		UserDetails user = User.withDefaultPasswordEncoder()
//								.username("techcrack")
//								.password("dummy")
//								.build();
//		
//		return new InMemoryUserDetailsManager(user);
//	}
	
	@Bean
	public InMemoryUserDetailsManager manageUserDetails() {
		// PassWord Encoder
//		Function<String, String> password = pass -> encodePassword().encode(pass);
		
		UserDetails user1 = createNewUser("techcrack", "dummy");
		UserDetails user2 = createNewUser("java", "123");
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
	private UserDetails createNewUser(String username, String password) {
		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder()
								.username(username)
								.password(password)
								.passwordEncoder(pass -> encodePassword().encode(pass))
								.roles("ADMIN", "USER")
								.build();
		
		return user;
	}
	
	@Bean
	public BCryptPasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception {
		
		// Authentication Required For All URL Enable
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated())
			// Login Form For All Unauthorized Access
			.formLogin(withDefaults())
			// Disable CSRF
			.csrf().disable()
			// Enable Frames for H2 Data Base
			.headers().frameOptions().disable();
		
		return http.build();
	}
	
//	@SuppressWarnings("removal")
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/h2-console/**").permitAll() // allow h2 console
//                .anyRequest().authenticated()
//            )
//            .headers(headers -> headers
//                .frameOptions().disable() // allow frames for h2 console
//            )
//            .csrf(csrf -> csrf
//                .ignoringRequestMatchers("/h2-console/**") // disable CSRF for h2 console
//            ); // or your custom login
//
//        return http.build();
//    }
}