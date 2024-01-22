package ec.edu.insteclrg.sig_api.dto.investigacion;

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
