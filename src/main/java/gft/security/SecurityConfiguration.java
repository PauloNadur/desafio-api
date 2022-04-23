package gft.security;

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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import gft.filter.FiltroAutenticacao;
import gft.services.AutenticacaoService;
import gft.services.UsuarioService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AutenticacaoService autenticacaoService;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/auth").permitAll()

		.antMatchers(HttpMethod.POST, "/api/v1/popular").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/v1/usuarios").hasAnyAuthority("ADMIN")

		.antMatchers(HttpMethod.GET, "/api/v1/categoria").hasAnyAuthority("ADMIN", "USER")
		.antMatchers(HttpMethod.GET, "/api/v1/categoria/*").hasAnyAuthority("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/api/v1/categoria").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/v1/categoria/*").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/v1/categoria/*").hasAnyAuthority("ADMIN")

		.antMatchers(HttpMethod.GET, "/api/v1/starter").hasAnyAuthority("ADMIN", "USER")
		.antMatchers(HttpMethod.GET, "/api/v1/starter/*").hasAnyAuthority("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/api/v1/starter").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/v1/starter/*").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/v1/starter/*").hasAnyAuthority("ADMIN")

		.anyRequest().authenticated().and().csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.addFilterBefore(new FiltroAutenticacao(autenticacaoService, usuarioService),
				UsernamePasswordAuthenticationFilter.class);
	}

}
