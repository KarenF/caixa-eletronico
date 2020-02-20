package br.com.compasso.caixaeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.caixaeletronico.entity.CaixaEletronico;

public interface CaixaEletronicoRepository extends JpaRepository<CaixaEletronico, Long> {

}
