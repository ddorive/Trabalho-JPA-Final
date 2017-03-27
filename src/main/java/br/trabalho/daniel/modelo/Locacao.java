package br.trabalho.daniel.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Locacao extends BaseEntity<Long>{

	private static final long serialVersionUID = 5529304031569205319L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_locacao", unique = true, nullable = false)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_locacao")
	private Date dataHora;
	
	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", insertable = true, updatable = false, nullable = false)
	private Pessoa pessoa;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinTable(name = "locacao_carro",
			joinColumns = @JoinColumn(name = "id_locacao"),
			inverseJoinColumns = @JoinColumn(name = "id_carro"))
	private List<Carro> carros;

	public Locacao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Carro> getCarros() {
		if (carros == null) {
			carros = new ArrayList<>();
		}
		return carros;
	}

	
}
