package ec.edu.insteclrg.sig_api.domain.vinculacion;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.domain.talentohumano.Docente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	
	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private Date fechainicio;

	@Column(nullable = false)
	private Date fechafin;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "docenteGestor_id")
	private Docente docenteGestor;
}