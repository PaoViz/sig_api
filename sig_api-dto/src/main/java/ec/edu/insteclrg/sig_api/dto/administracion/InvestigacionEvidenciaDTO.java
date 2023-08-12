package ec.edu.insteclrg.sig_api.dto.administracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InvestigacionEvidenciaDTO {
	
	private Long id;

	private String descripcion;

	private InvestigacionEtapaDTO investigacionEtapa;
	
	private String url;



}
