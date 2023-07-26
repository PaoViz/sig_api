package ec.edu.insteclrg.sig_api.domain.administracion;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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