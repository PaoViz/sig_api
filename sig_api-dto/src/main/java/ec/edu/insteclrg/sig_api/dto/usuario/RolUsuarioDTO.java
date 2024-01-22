package ec.edu.insteclrg.sig_api.dto.usuario;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.dto.general.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RolUsuarioDTO {
	
	private Long id;
	
	private UsuarioDTO usuario;
	
	private RolDTO rol;
	
	private Date fechaCreacion;
	
	private Boolean estado;

}
