package br.com.compasso.caixaeletronico.service;

import java.util.List;
import java.util.Optional;

import br.com.compasso.caixaeletronico.entity.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario);

	Optional<Usuario> findById(Long id);

	void deleteById(Long id);

	List<Usuario> list();
}
