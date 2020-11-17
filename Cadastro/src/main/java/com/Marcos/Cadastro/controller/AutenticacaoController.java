package com.Marcos.Cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Marcos.Cadastro.config.security.TokenService;
import com.Marcos.Cadastro.controller.form.LoginForm;
import com.Marcos.Cadastro.dto.TokenDto;

import ch.qos.logback.core.pattern.Converter;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	//responsavel por fazer a chamada de login
	@Autowired
	private AuthenticationManager authManager;
	
	//gera o token
	@Autowired
	private TokenService tokenService;
	
	//Novo end point que devolve token para acessar demais funcoes
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {

		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
