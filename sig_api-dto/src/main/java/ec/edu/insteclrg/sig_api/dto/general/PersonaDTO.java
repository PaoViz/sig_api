package ec.edu.insteclrg.sig_api.dto.general;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonaDTO {
	
	private Long id;

	private String primerApellido;

	private String segundoApellido;

	private String primerNombre;

	private String segundoNombre;

	
}
