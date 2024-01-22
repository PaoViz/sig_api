package ec.edu.insteclrg.sig_api.domain.investigacion;

import ec.edu.insteclrg.sig_api.domain.general.Ciclo;
import ec.edu.insteclrg.sig_api.domain.general.Periodo;
import ec.edu.insteclrg.sig_api.domain.talentohumano.Docente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pis {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
	
	@Column(nullable = false)
    private String descripcion;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "proyectoInvestigacion_id")
	private ProyectoInvestigacion proyectoInvestigacion;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "docente_id")
    private Docente docente;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "ciclo_id")
    private Ciclo ciclo;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "periodo_id")
    private Periodo periodo; 
}
