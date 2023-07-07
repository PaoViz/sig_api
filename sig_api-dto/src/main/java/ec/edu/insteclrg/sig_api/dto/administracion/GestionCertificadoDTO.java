package ec.edu.insteclrg.sig_api.dto.administracion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
public class GestionCertificadoDTO {
	
	private Long id;
	private Date fechaCreacion;
	private String titulo;
	private String descripcion;
	private CertifdicadoTipoDTO certificadoTipo;
	private PersonaDTO persona;
	private UsuarioDTO usuario;
}

