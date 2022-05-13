package com.Sync.Notification.api.configuration;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.ORIGIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.Sync.Notification.api.security.filter.JwtTokenAuthenticationFilter;
import com.Sync.Notification.api.security.filter.RestAccessDeniedHandler;
import com.Sync.Notification.api.security.filter.SecurityAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	public WebSecurityConfiguration() {
		super();
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		String secret = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("secret.key"),
				Charset.defaultCharset());

		http.csrf().disable()
				.addFilterAfter(jwtTokenAuthenticationFilter("/**", secret), ExceptionTranslationFilter.class)
				.addFilterAfter(corsFilter(), ExceptionTranslationFilter.class)
				/*
				 * Exception management is handled by the authenticationEntryPoint (for
				 * exceptions related to authentications) and by the AccessDeniedHandler (for
				 * exceptions related to access rights)
				 */
				.exceptionHandling().authenticationEntryPoint(new SecurityAuthenticationEntryPoint())
				.accessDeniedHandler(new RestAccessDeniedHandler()).and()
				/*
				 * anonymous() consider no authentication as being anonymous instead of null in
				 * the security context.
				 */
				.anonymous().and()
				/* No Http session is used to get the security context */
				.sessionManagement().sessionCreationPolicy(STATELESS).and().authorizeRequests()
				.antMatchers("/api/auth/**").permitAll().anyRequest().permitAll();

	}

	private JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter(String path, String secret) {
		return new JwtTokenAuthenticationFilter(path, secret);
	}

	private CorsFilter corsFilter() {
		/*
		 * CORS requests are managed only if headers Origin and
		 * Access-Control-Request-Method are available on OPTIONS requests (this filter
		 * is simply ignored in other cases).
		 * 
		 * This filter can be used as a replacement for the @Cors annotation.
		 */
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader(ORIGIN);
		config.addAllowedHeader(CONTENT_TYPE);
		config.addAllowedHeader(ACCEPT);
		config.addAllowedHeader(AUTHORIZATION);
		config.addAllowedMethod(GET);
		config.addAllowedMethod(PUT);
		config.addAllowedMethod(POST);
		config.addAllowedMethod(OPTIONS);
		config.addAllowedMethod(DELETE);
		config.addAllowedMethod(PATCH);
		config.setMaxAge(3600L);

		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
