package ec.edu.insteclrg.sig_api.dto.administracion;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CertificadoLaboralDTO {

	private Long id;
	
	private String nombreInstitucion;

	private Date fechaInicio;
	
	private Date fechaFin;

	private byte[] documento;
	
	private TipoCertificadoLaboralDTO tipoCertificadoLaboral;
	
	private PersonaDTO persona;

}
