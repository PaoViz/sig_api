package ec.edu.insteclrg.sig_api.dto.administracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DocenteDTO {

	private Long id;
	
	private PersonaDTO persona;
	
	private Boolean activo;
}
