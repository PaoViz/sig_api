package ec.edu.insteclrg.sig_api.domain.administracion;

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
@Table(name = "institucion")
public class Institucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false, unique = true)
	private String ruc;

	@Column(nullable = false, unique = true)
	private String nombre;

	@Column(nullable = false, unique = true)
	private String direccion;
	
	@Column(nullable = false, unique = true)
	private String telefono;
	
	@Column(nullable = false, unique = true)
	private String logo;


}
