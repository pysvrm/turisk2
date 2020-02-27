package mx.com.vrm.viai.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringSecurityConfiguration.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(SpringSecurityConfiguration.class);

	/** The user details service. */
	@Autowired
	UserDetailsService userDetailsService;

	/**
	 * Instantiates a new spring security configuration.
	 *
	 * @param userDetailsService
	 *            the user details service
	 */
	public SpringSecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/**
	 * Config authentication.
	 *
	 * @param auth
	 *            the auth
	 * @throws Exception
	 *             the exception
	 */
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
		;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.addFilterBefore(new JWTAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class)
		.authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll().antMatchers("/", "/home")
		.access("hasRole('ROLE_ANONYMOUS')")
		.antMatchers("/principal/**")
		.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.antMatchers("/resources/**").permitAll()
		.anyRequest().authenticated().and().formLogin().loginPage("/home").usernameParameter("ssoId")
		.passwordParameter("password").defaultSuccessUrl("/principal").and().exceptionHandling()
		.accessDeniedPage("/Access_Denied").and().csrf().disable()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	/**
	 * Cors configuration source.
	 *
	 * @return the cors configuration source
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

	/**
	 * Passwordencoder.
	 *
	 * @return the password encoder
	 */
	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
