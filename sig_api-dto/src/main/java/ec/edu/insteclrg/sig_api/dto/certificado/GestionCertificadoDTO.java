package ec.edu.insteclrg.sig_api.dto.certificado;





import java.sql.Date;

import ec.edu.insteclrg.sig_api.dto.general.CertifdicadoTipoDTO;
import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
import ec.edu.insteclrg.sig_api.dto.general.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

