package br.trabalho.daniel.modelo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "carro")
@Entity
public class Carro extends BaseEntity<Long>{

	private static final long serialVersionUID = -5149420057925592751L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_carro", unique = true, nullable = false)
	private Long id;
	
	@Column(name ="c_chassi", unique = true, nullable = false)
	private String chassi;
	
	@Column(name="c_motor", unique = true, nullable = false)
	private String motor;

	@Column(name = "c_marca", nullable = false, length = 100)
	private String marca;
	
	@Column(name = "c_montadora", length = 50)
	@Basic(fetch = FetchType.LAZY)
	private String montadora;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_garantia")
	@Basic(fetch = FetchType.LAZY)
	private Date garantia;

	public Carro() {
		super();
	}

	public Carro(Long id, String chassi, String motor, String marca) {
		super();
		this.id = id;
		this.chassi = chassi;
		this.motor = motor;
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public Date getGarantia() {
		return garantia;
	}

	public void setGarantia(Date garantia) {
		this.garantia = garantia;
	}

	
	
}
