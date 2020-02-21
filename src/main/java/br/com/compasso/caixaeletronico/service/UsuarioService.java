package br.com.compasso.caixaeletronico.service;

import java.util.Optional;

import br.com.compasso.caixaeletronico.entity.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario);
	
	int[] quantidadeNotas(int valor);

	Optional<Usuario> findById(Long id);

	void deleteById(Long id);
}
