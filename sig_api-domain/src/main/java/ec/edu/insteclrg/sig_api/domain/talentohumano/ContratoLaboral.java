package ec.edu.insteclrg.sig_api.domain.talentohumano;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.domain.general.Cargo;
import ec.edu.insteclrg.sig_api.domain.general.GrupoOcupacional;
import ec.edu.insteclrg.sig_api.domain.general.ModalidadContrato;
import ec.edu.insteclrg.sig_api.domain.general.Persona;
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
@Table(name = "contrato_laboral")
public class ContratoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "modalidad_contrato_id")
	private ModalidadContrato modalidad_contrato;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "grupo_ocupacional_id")
	private GrupoOcupacional grupo_ocupacional;

	@Column(nullable = false, unique = true)
	private Float renumeracion;
	
	@Column(nullable = false, unique = true)
	private Date fecha_ingreso;
	
	@Column(nullable = false, unique = true)
	private Date fecha_salida;
	
	@Column(nullable = true)
	private byte[] documento;
	
	
	
	
	
	
}
