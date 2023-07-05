package ec.edu.insteclrg.sig_api.dto.administracion;

import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class EstudianteDTO {
	
	private Long id;
	
	private PersonaDTO persona;

}
