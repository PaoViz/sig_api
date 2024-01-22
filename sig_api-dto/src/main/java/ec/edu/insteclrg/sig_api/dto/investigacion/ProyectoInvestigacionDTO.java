package ec.edu.insteclrg.sig_api.dto.investigacion;


import ec.edu.insteclrg.sig_api.dto.talentohumano.DocenteDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProyectoInvestigacionDTO {

private Long id;
	
	private String urlproyecto;
	
	private DocenteDTO docente;
}
