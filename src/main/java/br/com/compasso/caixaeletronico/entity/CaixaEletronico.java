package br.com.compasso.caixaeletronico.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "caixa")
public class CaixaEletronico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3476604437263481035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	@Column(nullable = false)
	private BigDecimal valor;
}
