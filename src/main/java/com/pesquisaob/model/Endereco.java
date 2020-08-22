package com.pesquisaob.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 7746746688938012929L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	@Getter
	@Setter
	private String rua;
	@Getter
	@Setter
	private String bairro;
	@Getter
	@Setter
	private String cep;
	@Getter
	@Setter
	private String estado;
	@Getter
	@Setter
	private String cidade;
	
	@ManyToOne
	private Pessoa pessoa;
}
