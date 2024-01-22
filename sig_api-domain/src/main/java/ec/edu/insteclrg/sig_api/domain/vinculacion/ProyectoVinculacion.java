package ec.edu.insteclrg.sig_api.domain.vinculacion;

import ec.edu.insteclrg.sig_api.domain.talentohumano.Docente;
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
@Table(name = "proyectoVinculacion")
public class ProyectoVinculacion extends Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn()
	private Docente docenteAdministrador;

	@Column(nullable = false)
	private String urlProyecto;
	
	@Column()
	private String urlItv;
	
	
}
