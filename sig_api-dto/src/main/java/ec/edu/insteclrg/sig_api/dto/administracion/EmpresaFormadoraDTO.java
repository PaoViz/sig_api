package ec.edu.insteclrg.sig_api.dto.administracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpresaFormadoraDTO {
	
	private Long id;
	
	private String ruc;
	
	private String descripcion;
	
	private SectorProductivoDTO sectorProductivo;
}
