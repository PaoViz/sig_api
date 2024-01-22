package ec.edu.insteclrg.sig_api.dto.vinculacion;

import ec.edu.insteclrg.sig_api.dto.talentohumano.DocenteDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProyectoVinculacionDTO {
	
	
	private Long id;

	private DocenteDTO docenteAdministrador;
	
	private String urlProyecto;

	private String urlItv;

}
