//package com.spring.SpringBoot.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class MyWebSecurity {
//			//Authentication
//		 	@Bean
//		    public UserDetailsService userDetailsService() {
//
//		        UserDetails admin1 = User.builder()
//		                .username("jetha") //CRUD
//		                .password(passwordEncoder().encode("jetha123"))
//		                .authorities("ADMIN")
//		                .build();
//		        
//		        UserDetails admin2 = User.builder()
//		                .username("tappu") //CRUD
//		                .password(passwordEncoder().encode("tappu123"))
//		                .authorities("ADMIN")
//		                .build();
//
//		        UserDetails user1 = User.builder()
//		                .username("bagha") //CR
//		                .password(passwordEncoder().encode("bagha123"))
//		                .authorities("USER")
//		                .build();
//		        
//		        UserDetails user2 = User.builder()
//		                .username("magan") //CR
//		                .password(passwordEncoder().encode("magan123"))  //encoding  Bcrypt
//		                .authorities("USER")
//		                .build();
//
//		        return new InMemoryUserDetailsManager(admin1, admin2,user1,user2);
//		    }
//
//		    @Bean
//		    public PasswordEncoder passwordEncoder() {
//		        return new BCryptPasswordEncoder();
//		    }
//		    
//		    //Authorisation
//		    @Bean  
//		    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		        
//		        http.authorizeRequests()
//		        .requestMatchers("/show-all-products","/add-new-product1").hasAnyAuthority("USER","ADMIN")
//		        .requestMatchers("/deleteProductUI/**","/updateProductFormFE/**").hasAuthority("ADMIN")
//		        .anyRequest().authenticated()
//		        .and()
//		        .formLogin().loginProcessingUrl("/login").successForwardUrl("/show-all-products").permitAll()
//		        .and()
//		        .logout().logoutSuccessUrl("/login").permitAll()
//		        .and()
//		        .exceptionHandling().accessDeniedPage("/403")
//		        .and()
//		        .cors().and().csrf().disable();
//		        return http.build();
//		    }
//}
//
//
