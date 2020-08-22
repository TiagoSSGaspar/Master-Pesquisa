package com.pesquisaob.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class DbConnection {
	
	private EntityManagerFactory fabrica = null;
	
	public DbConnection() {
		if (this.fabrica == null) {
			this.fabrica = Persistence.createEntityManagerFactory("pesquisaOb");
		}
	}
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return this.fabrica.createEntityManager();
	}
	


}
