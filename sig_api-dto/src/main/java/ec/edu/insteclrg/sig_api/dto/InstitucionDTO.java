package ec.edu.insteclrg.sig_api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class InstitucionDTO {
	
	private Long id;

	private String ruc;

	private String nombre;

	private String direccion;
	
	private String telefono;

	private String logo;

}
