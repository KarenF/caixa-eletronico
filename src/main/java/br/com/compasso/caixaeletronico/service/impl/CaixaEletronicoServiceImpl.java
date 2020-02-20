package br.com.compasso.caixaeletronico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.caixaeletronico.entity.CaixaEletronico;
import br.com.compasso.caixaeletronico.repository.CaixaEletronicoRepository;
import br.com.compasso.caixaeletronico.service.CaixaEletronicoService;

@Service
public class CaixaEletronicoServiceImpl implements CaixaEletronicoService {

	@Autowired
	CaixaEletronicoRepository repository;
	
	@Override
	public CaixaEletronico save(CaixaEletronico caixa) {
		return repository.save(caixa);
	}

}
