package br.com.compasso.caixaeletronico.service;

import java.util.Optional;

import br.com.compasso.caixaeletronico.entity.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario);
	
	Optional<Usuario> quantidadeNotas(int valor);
}
