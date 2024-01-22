package ec.edu.insteclrg.sig_api.domain.administracion;

import java.sql.Date;

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
public class ProyectoVinculacionPlanificacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
	
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "periodo_id")
    private Periodo periodo;
	
	@Column(nullable = false)
    private String horasPlanificadas;
	
	@Column()
	private Date fechaInicio;
    
    @Column()
	private Date fechaFin;
    
    
    
    
}
