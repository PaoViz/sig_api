package ec.edu.insteclrg.sig_api.dto.talentohumano;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
import ec.edu.insteclrg.sig_api.dto.general.TipoTituloAcademicoDTO;
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
