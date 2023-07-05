package ec.edu.insteclrg.sig_api.dto.administracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
public class GestionCertificadoDTO {
	
	private Date fechaCreacion;
	private String titulo;
	private String descripcion;
	private long idCertificadoTipo;
	private long idPersona;
	private long idUsuario;
}
