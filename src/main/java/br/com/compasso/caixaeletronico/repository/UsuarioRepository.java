package br.com.compasso.caixaeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.caixaeletronico.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
