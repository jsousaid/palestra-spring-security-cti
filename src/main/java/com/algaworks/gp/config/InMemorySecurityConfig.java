package com.algaworks.gp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

//@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
	        // aqui eu configuro dois usuários na memória, sem usar nenhum tipo de banco de dados e já colocando as respectivas permissões para cada usuário.
		builder
			.inMemoryAuthentication()
			.withUser("carlos").password("123").roles("PG_PROJETOS", "PG_REL_CUSTOS", "PG_REL_EQUIPE")
			.and()
			.withUser("flavio").password("123").roles("PG_PROJETOS", "PG_REL_EQUIPE");
	}

}
