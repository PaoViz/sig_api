package ec.edu.insteclrg.sig_api.domain.administracion;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class GrupoOcupacional {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(updatable = false, nullable = false)
	    private Long id;

	    @Column(nullable = false)
	    private String descripcion;

}
