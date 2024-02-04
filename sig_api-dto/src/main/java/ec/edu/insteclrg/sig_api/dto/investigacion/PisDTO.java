package ec.edu.insteclrg.sig_api.dto.general;

import ec.edu.insteclrg.sig_api.dto.investigacion.ProyectoInvestigacionDTO;
import ec.edu.insteclrg.sig_api.dto.talentohumano.DocenteDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PisDTO {

	 private Long id;
	 
	    private String descripcion;
	    
	    private ProyectoInvestigacionDTO proyecto;
		
	    private DocenteDTO docente;

	    private CicloDTO ciclo;
		
	    private PeriodoDTO periodo;
}
