package com.cafimanager.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth

				.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll()
				// .antMatchers("/").anonymous()
				.antMatchers("/login").permitAll()
				// .antMatchers("/login").anonymous()
				.antMatchers("/registration").permitAll()

				.antMatchers("/admin/*").hasAuthority("ADMIN")
				// .anyRequest()
				// .authenticated()

				.antMatchers("/client/*").hasAuthority("CLIENT")
				// .anyRequest()
				// .authenticated()

				.antMatchers("/caissier/*").hasAuthority("CAISSIER")
				// .anyRequest()
				// .authenticated()
				.antMatchers("/home").authenticated().and().csrf().disable().formLogin().loginPage("/login")
				.failureUrl("/login?error=true").defaultSuccessUrl("/home", true).usernameParameter("email")
				.passwordParameter("password")

				.and().logout().invalidateHttpSession(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
		// .and()

		// .exceptionHandling().accessDeniedPage("/access-denied");

		http.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry()).expiredUrl("/login?expired=true");
		
		http.sessionManagement()
		//.expiredUrl("/sessionExpired.html")
		  .invalidSessionUrl("/invalidSession.html");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/resources/**", "/static/**", "/assets/**", "/css/**", "/js/**", "/images/**");

	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}

}
