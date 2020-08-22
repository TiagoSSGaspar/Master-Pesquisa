package com.pesquisaob.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PessoaFisica extends Pessoa implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private String cpf;
	@Getter @Setter private String rg;
	
}
