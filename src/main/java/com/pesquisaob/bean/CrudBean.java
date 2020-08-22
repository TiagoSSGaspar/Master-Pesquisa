package com.pesquisaob.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.pesquisaob.dao.CrudIDAO;
import com.pesquisaob.utils.ErroSistema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("rawtypes")
@NoArgsConstructor
public abstract class CrudBean<E, D extends CrudIDAO> implements Serializable {


	private static final long serialVersionUID = 1L;

	private String estadoTela = "buscar";


	@Getter
	@Setter
	private E enitidade;
	
	@Getter
	@Setter
	private List<E> listaEntidades;

	public void novo() {
		this.enitidade = criarNovaEntidade();
		mudarModoInsercao();
	}

	@SuppressWarnings("unchecked")
	public void salvar(E entidade) {
		try {
			getDAO().salvar(entidade);
			entidade = criarNovaEntidade();
			addMsg("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
			mudarModoBusca();
		} catch (ErroSistema e) {
			e.printStackTrace();
		}
		

	}

	public void editar(E entidade) {
		this.enitidade = entidade;
		mudarModoIdicao();
		this.listaEntidades.remove(entidade);
	}

	@SuppressWarnings("unchecked")
	public void deletar(E entidade) {
		try {
			getDAO().deletar(entidade);
			addMsg("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
			this.mudarModoBusca();			
		} catch (ErroSistema e) {			
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void buscar() {
		if (!this.isBuscando()) {
			this.mudarModoBusca();
			return;
		}
		
		try {
			this.listaEntidades = getDAO().listar();
			if (this.listaEntidades == null || this.listaEntidades.size() >= 0 ) {
				addMsg("Não temos nada cadastrado!", FacesMessage.SEVERITY_WARN);
			}
		} catch (ErroSistema e) {
			e.printStackTrace();
		}
	}

	public void addMsg(String msg, FacesMessage.Severity tipo) {
		FacesMessage messagem = new FacesMessage(tipo, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, messagem);
	}

	public abstract D getDAO();

	public abstract E criarNovaEntidade();

	public boolean isInserindo() {
		return "inserindo".equals(this.estadoTela);
	}

	public boolean isEditando() {
		return "editando".equals(this.estadoTela);
	}

	public boolean isBuscando() {
		return "buscando".equals(this.estadoTela);
	}

	public void mudarModoInsercao() {
		this.estadoTela = "inserindo";
	}

	public void mudarModoIdicao() {
		this.estadoTela = "editando";
	}

	public void mudarModoBusca() {
		this.estadoTela = "buscando";
	}

}
