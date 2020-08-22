package com.pesquisaob.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
@NamedQuery(name = "Pessoa.findByEmail", 
query = "Select p from Pessoa p where p.email = :email")
@NamedQuery(name = "Pessoa.findByEmailSenha", 
query = "Select p from Pessoa p where p.email = :email AND p.senha = :senha")
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private Date aniversario;
	@Getter
	@Setter
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	@Getter
	@Setter
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Telefone> telefones = new ArrayList<Telefone>();
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String senha;

}
