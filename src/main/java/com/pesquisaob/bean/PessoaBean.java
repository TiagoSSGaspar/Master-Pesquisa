package com.pesquisaob.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pesquisaob.dao.PessoaDAO;
import com.pesquisaob.model.Pessoa;
import com.pesquisaob.model.PessoaFisica;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "pessoaBean")
public class PessoaBean extends CrudBean<Pessoa, PessoaDAO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaDAO pessoaDAO;
	
	@Inject
	private PessoaFisica pessoaFisica;
	

	//private PessoaFisica pessoaFisica;


	//private Pessoa user;
	
	@Getter
	@Setter
	private boolean pj;

	@Override
	public PessoaDAO getDAO() {

		return pessoaDAO;
	}

	@Override
	public Pessoa criarNovaEntidade() {		

		return pessoaFisica;
	}

}
