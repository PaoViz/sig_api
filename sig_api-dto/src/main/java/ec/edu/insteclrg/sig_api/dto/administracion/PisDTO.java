package ec.edu.insteclrg.sig_api.dto.administracion;

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
