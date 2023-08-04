package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GestionDocumentalConvenioDTO {
	
	private Long id;

	private TipoConvenioDTO tipoConvenio;
	
	private String descripcion;

	private String url;

	private Date fechaInicio;

	private Date fechaFin;

	private GestionDocumentalDTO gestionDocumental;


	

}
