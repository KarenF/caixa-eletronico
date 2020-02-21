package br.com.compasso.caixaeletronico.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

	private Long id;
	@Length(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
	@NotNull(message = "Informe um nome")
	private String nome;
	@NotNull(message = "Informe um valor")
	private int valor;
}
