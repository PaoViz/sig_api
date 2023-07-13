package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TituloAcademicoDTO {

	private Long id;
	
	private PersonaDTO persona;
	
	private String descripcion;
	
	private String numeroRegistro;
	
	private Date fechaRegistroTitulo;
	
	private TipoTituloAcademicoDTO tipoTituloAcademico;
}
