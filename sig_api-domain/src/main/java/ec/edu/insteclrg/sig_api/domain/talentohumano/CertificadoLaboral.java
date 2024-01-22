package ec.edu.insteclrg.sig_api.domain.talentohumano;


import java.sql.Date;

import ec.edu.insteclrg.sig_api.domain.general.Persona;
import ec.edu.insteclrg.sig_api.domain.general.TipoCertificadoLaboral;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "certificadoLaboral")
public class CertificadoLaboral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false)
	private String nombreInstitucion;
	
	@Column(nullable = false)
	private Date fechaInicio;
	
	@Column(nullable = false)
	private Date fechaFin;
	
	@Column()
	private byte[] documento;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private TipoCertificadoLaboral tipoCertificadoLaboral;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private Persona persona;

}
