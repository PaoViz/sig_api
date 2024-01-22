package ec.edu.insteclrg.sig_api.dto.vinculacion;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.dto.general.PeriodoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProyectoVinculacionPlanificacionDTO {

    private Long id;

    private PeriodoDTO periodo;
	
    private String horasPlanificadas;

	private Date fechaInicio;

	private Date fechaFin;
}
