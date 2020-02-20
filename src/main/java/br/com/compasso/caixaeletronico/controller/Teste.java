package br.com.compasso.caixaeletronico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {

	@RequestMapping("teste")
	public String Hello() {
		return "Primeiro teste spring boot";
	}
}