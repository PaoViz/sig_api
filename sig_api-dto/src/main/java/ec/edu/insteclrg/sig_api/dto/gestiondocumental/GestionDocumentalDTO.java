package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GestionDocumentalDTO {
	
	private Long id;
	
	private String descripcion;

	private Date fechaCreacion;
	
	private String observacion ;

	private Long idGestionDocumentalPadre;
	
	private Boolean limite;

	private String rolesAcceso;


}
