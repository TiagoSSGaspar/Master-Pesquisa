package com.pesquisaob.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.pesquisaob.model.Pessoa;



@Named
public class PessoaDAO implements CrudIDAO<Pessoa> {

	@Inject
	private EntityManager manager;
	
	public void salvar(Pessoa pessoa) {
		EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		this.manager.merge(pessoa);

		transaction.commit();
		

	}

	public Pessoa procurarEmail(String email) {
		EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		Pessoa pessoa;
		try {
			pessoa = this.manager.createNamedQuery("Pessoa.findEmail", Pessoa.class).setParameter("email", email)
					.getSingleResult();

			return pessoa;
		} catch (Exception e) {
			return null;
		}

	}

	public Pessoa procurarEmailSenha(String email, String senha) {
		EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();
		transaction.begin();

		Pessoa pessoa;
		try {
			pessoa = (Pessoa) this.manager.createNamedQuery("Pessoa.findByEmailSenha").setParameter("email", email)
					.setParameter("senha", senha).getSingleResult();

			return pessoa;
		} catch (Exception e) {
			return null;
		}
	}

	public void deletar(Pessoa pessoa) {
		EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();


		Pessoa id = this.manager.find(Pessoa.class, pessoa.getId());
		//Object id = JPAUtil.getPKey(pessoa);

		this.manager.createQuery("delete from " + pessoa.getClass().getName() + " where id = " + id).executeUpdate();

		transaction.commit();

	}

	public List<Pessoa> listar() {
		EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		List<Pessoa> list = this.manager.createQuery("SELECT c FROM Pessoa c", Pessoa.class).getResultList();

		return list;
	}

}
