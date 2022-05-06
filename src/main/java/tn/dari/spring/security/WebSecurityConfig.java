package tn.dari.spring.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import tn.dari.spring.jwt.AuthEntryPointJwt;
import tn.dari.spring.jwt.AuthTokenFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	 @Override
	    public void configure(WebSecurity web) {
	        web.ignoring().antMatchers("/v2/api-docs","/v3/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**",
	                "/swagger-ui.html", "/webjars/**");
	    }

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.cors().and().csrf().disable()
////			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
////			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////			.authorizeRequests().antMatchers("/api/auth/**","/send","/swagger-ui/**","/chat-websocket/**","/api/auth/**",
////					"/chat","/profile","/chat/message").permitAll()
////			.antMatchers("/api/test/**","/swagger-ui/**","/chat-websocket/**","/chat","/profile","/chat/message").permitAll()
////			.anyRequest().authenticated();
////		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
////		
//		
//		http.csrf().disable();
//		http.authorizeRequests()
//	.antMatchers("/admin/**").hasRole("ADMIN")
//	
//	.antMatchers("/","/home","/profile").permitAll();
//	//        .antMatchers("/user/allUsers").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_ACHETEUR", "ROLE_VENDEUR","ROLE_BAILLEUR","ROLE_LOCATAIRE")
////        .anyRequest().permitAll();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//	}
	


   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/","/file/**","file/**",
                		"/favicon.ico",
                        "/**/*.json",
                        "/**/*.xml",
                        "/**/*.properties",
                        "/**/*.woff2",
                        "/**/*.woff",
                        "/**/*.ttf",
                        "/**/*.ttc",
                        "/**/*.ico",
                        "/**/*.bmp",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.jpeg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js").permitAll()
                .antMatchers("/**/api/auth/**","/**/user/**","/role/**","/user/checkEmail","/user/allUsers","/chat-websocket/**","/api/auth/**","/user/**").permitAll()
        .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated();

        
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
