package ec.edu.insteclrg.sig_api.dto.general;

import ec.edu.insteclrg.sig_api.dto.investigacion.PaisDTO;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class ProvinciaDTO {
	
	private Long id;
	
	private String nombre;
	
	private PaisDTO pais;
	
}
