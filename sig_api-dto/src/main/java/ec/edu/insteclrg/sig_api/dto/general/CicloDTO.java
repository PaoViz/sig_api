package ec.edu.insteclrg.sig_api.dto.general;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CicloDTO {
	
	private Long id;

	private String descripcion;
	
	private CarreraDTO carrera;

}
