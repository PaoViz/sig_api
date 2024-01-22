package ec.edu.insteclrg.sig_api.domain.investigacion;

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
@Table(name = "investigacionEtapa")
public class InvestigacionEtapa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String descripcion; 
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "proyectoinvestigacion_id")
	private ProyectoInvestigacion proyectoinvestigacion;
}
