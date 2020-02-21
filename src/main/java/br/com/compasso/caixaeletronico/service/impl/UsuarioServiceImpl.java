package br.com.compasso.caixaeletronico.service.impl;

import java.util.List;
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
	public List<Usuario> list() {
		return repository.findAll();
	}
	
	@Override
	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
