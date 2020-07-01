package com.algaworks.gp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.algaworks.gp.security.GpUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private GpUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
			        // aqui determino cada role que o usuário precisa ter para acessar cada página
				.antMatchers("/projetos").hasAnyRole("PG_PROJETOS")
				.antMatchers("/relatorio-equipe").hasAnyRole("PG_REL_EQUIPE")
				.antMatchers("/relatorio-custos").hasAnyRole("PG_REL_CUSTOS")
				// aqui fala que para qualquer requisição o usuário precisa estar autenticado
				.anyRequest().authenticated()
			.and()
			// aqui fala que é para usar um formulário HTML no login, nesse caso usa o criado no resources, mas poderia ser o default do spring security
			.formLogin()
				.loginPage("/entrar")
				// aqui eu permito o acesso para essa url, se não o método '.anyRequest().authenticated()' não deixaria
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/entrar?logout")
				.permitAll()
			.and()
			.rememberMe()
				.userDetailsService(userDetailsService);
	}
}
