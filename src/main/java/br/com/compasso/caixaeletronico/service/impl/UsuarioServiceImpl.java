package br.com.compasso.caixaeletronico.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.caixaeletronico.entity.Usuario;
import br.com.compasso.caixaeletronico.repository.UsuarioRepository;
import br.com.compasso.caixaeletronico.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repository;

	@Override
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Optional<Usuario> quantidadeNotas(int valor) {

		int[] notas = { 100, 50, 20, 10, 5, 2, 1 };
		int[] resultado = { 0, 0, 0, 0, 0, 0, 0 };

		while (valor != 0) {
			if (valor >= 100) {
				resultado[0] = valor / notas[0];
				valor = valor - (resultado[0] * 100);
			} else if (valor >= 50) {
				resultado[1] = valor / notas[1];
				valor = valor - (resultado[1] * 50);
			} else if (valor >= 20) {
				resultado[2] = valor / notas[2];
				valor = valor - (resultado[2] * 20);
			} else if (valor >= 10) {
				resultado[3] = valor / notas[3];
				valor = valor - (resultado[3] * 10);
			} else if (valor >= 5) {
				resultado[4] = valor / notas[4];
				valor = valor - (resultado[4] * 5);
			} else if (valor >= 2) {
				resultado[5] = valor / notas[5];
				valor = valor - (resultado[5] * 2);
			} else if (valor >= 1) {
				resultado[6] = valor / notas[6];
				valor = valor - (resultado[6] * 1);
			}
		}

		for (int i = 0; i < resultado.length; i++) {
			System.out.println("Número de notas de " + notas[i] + " é igual a " + resultado[i]);
		}

		return repository.quantidadeNotas(resultado);
	}
}
