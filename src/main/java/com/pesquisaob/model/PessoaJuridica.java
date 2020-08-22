package com.pesquisaob.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaJuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private String cnpj;
	@Getter @Setter private String inscricaoEstadual;
	@Getter @Setter private String razaoSocial;

}
