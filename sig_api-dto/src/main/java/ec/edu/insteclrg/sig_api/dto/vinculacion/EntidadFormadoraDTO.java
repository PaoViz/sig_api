package ec.edu.insteclrg.sig_api.dto.vinculacion;

import ec.edu.insteclrg.sig_api.dto.general.SectorProductivoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EntidadFormadoraDTO {
	
	private Long id;
	
	private String ruc;
	
	private String descripcion;
	
	private SectorProductivoDTO sectorProductivo;
}
