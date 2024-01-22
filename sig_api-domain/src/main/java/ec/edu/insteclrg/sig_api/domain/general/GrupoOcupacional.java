package ec.edu.insteclrg.sig_api.domain.general;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class GrupoOcupacional {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(updatable = false, nullable = false)
	    private Long id;

	    @Column(nullable = false)
	    private String descripcion;

}
