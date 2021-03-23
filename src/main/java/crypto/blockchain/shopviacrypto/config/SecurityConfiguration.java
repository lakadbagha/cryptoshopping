package crypto.blockchain.shopviacrypto.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import crypto.blockchain.shopviacrypto.dao.AccountDao;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	AccountDao accountService;

//	@Autowired
//	private AccessDeniedHandler accessDeniedHandler;

//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth.jdbcAuthentication().dataSource(dataSource)
////				.usersByUsernameQuery("select email as principal, password as credentails, true from account where email=?")
////				.authoritiesByUsernameQuery("select email as principal, role_type as role from account where email=?")
////				.passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
//		
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests()
				// .antMatchers("**/secured/**").authenticated()
				// .anyRequest().permitAll()
				// .and()
				// .formLogin().permitAll();
				// .antMatchers("/user/secure/**").hasAnyRole("USER")
				// .antMatchers("/admin/secure/**").hasAnyRole("ADMIN")
				// .antMatchers("/moderator/secure/**").hasAnyRole("MODERATOR")
				// .antMatchers("/superuser/secure/**").hasAnyRole("SUPERUSER")
				// .antMatchers("/superadmin/secure/**").hasAnyRole("SUPERADMIN")
				// .antMatchers("/index/**").permitAll()
				// .and().formLogin()
				// .loginPage("/login")
				// .loginProcessingUrl("/app-login"))
				// .defaultSuccessUrl("/secure/topic-details")
				// .and().logout()
				// .logoutUrl("/app-logout")
				// .logoutSuccessUrl("/login")
				// .and().exceptionHandling()
				// .accessDeniedPage("/error");
//				.antMatchers("/**").permitAll()
				.antMatchers("/", "/index").permitAll()
				.antMatchers("/asset/**").permitAll()
				.antMatchers("/user/**").hasAnyRole("USER")
				.and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/secure", true)
				.and()
				.logout().logoutSuccessUrl("/index");
	}

	@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/resources/**");
		}
}
