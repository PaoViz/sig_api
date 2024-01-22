package ec.edu.insteclrg.sig_api.domain.investigacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "InvestigacionDocente")
public class InvestigacionDocente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "idProyectoAcademico", nullable = false)
	private Long idProyectoAcademico;
	
	@Column(name = "idDocente", nullable = false)
	private Long idDocente;
}
