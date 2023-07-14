package ec.edu.insteclrg.sig_api.domain.administracion;

import java.sql.Date;

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
@Table(name = "gestionDocumental")
public class GestionDocumental {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private Date fechaCreacion;

	@Column
	private String observacion ;
	
	@Column
	private Long idGestionDocumentalPadre;
	
	@Column(nullable = false)
	private Boolean limite;
	
	@Column(nullable = false)
	private String rolesAcceso;
	
}
