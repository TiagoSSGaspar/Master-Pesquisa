package com.pesquisaob.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	private Long id;
	@Getter
	@Setter
	private String nomeFantasia;
	

}
