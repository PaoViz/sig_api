package ec.edu.insteclrg.sig_api.dto.vinculacion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class ProyectoVinculacionPlanificacionPersonalDTO {
	


	    private Long id;

	    private Long idProyectoPlanificacion;

	    private Long idDocenteTutor;

	    private Long idEstudiante;

	    private String urlDocumento;

	    private String estadoProyecto;
	}




