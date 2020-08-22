package com.pesquisaob.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.pesquisaob.dao.PessoaDAO;
import com.pesquisaob.model.Pessoa;
import com.pesquisaob.model.PessoaFisica;

import lombok.Getter;
import lombok.Setter;

@javax.faces.view.ViewScoped
@Named(value = "pessoaBean")
public class PessoaBean extends CrudBean<Pessoa, PessoaDAO> implements Serializable {

	private static final long serialVersionUID = 1L;


	private PessoaDAO pessoaDAO;
	
	@Getter
	@Setter
	private PessoaFisica pessoaFisica;
	
	/*
	@Getter
	@Setter
	@Inject
	@Named(value = "pf")
	private PessoaFisica pessoaFisica;
	*/
	// @Inject
	// private Pessoa user;
	@Getter
	@Setter
	private boolean pj;

	@Override
	public PessoaDAO getDAO() {

		return pessoaDAO;

	}

	@Override
	@Inject
	public Pessoa criarNovaEntidade() {		

		return pessoaFisica;
	}

}
