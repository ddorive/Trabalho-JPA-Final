package br.trabalho.daniel.modelo;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Pessoa  extends BaseEntity<Long>{

	private static final long serialVersionUID = -4469407607805791163L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pessoa", unique = true, nullable = false)
	private Long id;

	@Column(name = "p_nome", nullable = false, length = 100)
	private String nome;
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "p_cpf", length = 20)
	private String cpf;
	
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Locacao> locacao;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

		
	public List<Locacao> getLocacao() {
		return locacao;
	}


}
