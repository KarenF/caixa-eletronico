package br.com.compasso.caixaeletronico.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5835851482446109795L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private int valor;
	@Column(nullable = false)
	private int notas;
	
	public String getNotas(int valor) {

		int[] notas = { 100, 50, 20, 10, 5, 2, 1 };
		int[] resultado = { 0, 0, 0, 0, 0, 0, 0 };

		while (valor != 0) {
			if (valor >= 100) {
				resultado[0] = valor / notas[0];
				valor = valor - (resultado[0] * 100);
			} else if (valor >= 50) {
				resultado[1] = valor / notas[1];
				valor = valor - (resultado[1] * 50);
			} else if (valor >= 20) {
				resultado[2] = valor / notas[2];
				valor = valor - (resultado[2] * 20);
			} else if (valor >= 10) {
				resultado[3] = valor / notas[3];
				valor = valor - (resultado[3] * 10);
			} else if (valor >= 5) {
				resultado[4] = valor / notas[4];
				valor = valor - (resultado[4] * 5);
			} else if (valor >= 2) {
				resultado[5] = valor / notas[5];
				valor = valor - (resultado[5] * 2);
			} else if (valor >= 1) {
				resultado[6] = valor / notas[6];
				valor = valor - (resultado[6] * 1);
			}
		}

		for (int i = 0; i < resultado.length; i++) {
			System.out.println("Número de notas de " + notas[i] + " é igual a " + resultado[i]);
		}

		return Arrays.toString(resultado);
	}
}
