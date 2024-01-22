package ec.edu.insteclrg.sig_api.dto.gestiondocumental;

import ec.edu.insteclrg.sig_api.dto.general.CarreraDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstructuraConvenioCarreraDTO {
	
	private Long id;
	
	private GestionDocumentalConvenioDTO gestionDocumentalConvenio;
	
	private CarreraDTO carrera;

}
