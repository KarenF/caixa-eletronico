package br.com.compasso.caixaeletronico.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaixaEletronicoDTO {

	private Long id;
	@NotNull(message = "Insira o id do usuario")
	private Long usuario;
	@NotNull(message = "Informe um valor")
	private BigDecimal valor;
}
