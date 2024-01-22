package ec.edu.insteclrg.sig_api.dto.gestiondocumental;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.dto.general.PeriodoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GestionDocumentalDocumentoDTO {
	private Long id;
	
	private String codigo;
	
	private String titulo;
	
	private Date fechaCreacion;
	
	private String url;
	
	private String observacion;
	
	private PeriodoDTO periodo;
	
	private GestionDocumentalDTO gestionDocumental;
	
}
