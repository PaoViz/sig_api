package ec.edu.insteclrg.sig_api.dto.gestiondocumental;

import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstudianteDTO {
	
	private Long id;
	
	private PersonaDTO persona;

}
