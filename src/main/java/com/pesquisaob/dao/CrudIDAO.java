package com.pesquisaob.dao;

import java.util.List;

import com.pesquisaob.utils.ErroSistema;

public interface CrudIDAO<E> {

	void salvar(E entidade) throws ErroSistema;
	void deletar(E entidade) throws ErroSistema;
	List<E> listar() throws ErroSistema;
	
}
