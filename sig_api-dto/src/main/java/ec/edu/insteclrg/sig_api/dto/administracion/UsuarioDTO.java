package ec.edu.insteclrg.sig_api.dto.administracion;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class UsuarioDTO {

	private Long id;
	private String username;
	private String password;
	private String roles;
	private Boolean enabled;

}
