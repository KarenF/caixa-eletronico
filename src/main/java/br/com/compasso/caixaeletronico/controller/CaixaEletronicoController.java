package br.com.compasso.caixaeletronico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.caixaeletronico.dto.CaixaEletronicoDTO;
import br.com.compasso.caixaeletronico.entity.CaixaEletronico;
import br.com.compasso.caixaeletronico.response.Response;
import br.com.compasso.caixaeletronico.service.CaixaEletronicoService;

@RestController
@RequestMapping("caixa")
public class CaixaEletronicoController {

	@Autowired
	private CaixaEletronicoService service;
	
	@PostMapping
	ResponseEntity<Response<CaixaEletronicoDTO>> create(@Valid @RequestBody CaixaEletronicoDTO dto, BindingResult result){
		Response<CaixaEletronicoDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		CaixaEletronico caixa = service.save(this.convertDtoToEntity(dto));
		response.setData(this.convertEntityToDto(caixa));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private CaixaEletronico convertDtoToEntity(CaixaEletronicoDTO dto) {
		CaixaEletronico caixa = new CaixaEletronico();
		caixa.setId(dto.getId());
		caixa.setValor(dto.getValor());
		return caixa;
	}
	
	private CaixaEletronicoDTO convertEntityToDto(CaixaEletronico caixa) {
		CaixaEletronicoDTO dto = new CaixaEletronicoDTO();
		dto.setId(caixa.getId());
		dto.setValor(caixa.getValor());
		return dto;
	}
}
