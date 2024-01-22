package ec.edu.insteclrg.sig_api.dto.talentohumano;


import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
import ec.edu.insteclrg.sig_api.dto.general.TipoAdministrativoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AdministrativoDTO {
	
	private Long id;
	
	private PersonaDTO persona;
	
	private Boolean activo;
	
	private TipoAdministrativoDTO tipo_administrativo;


}