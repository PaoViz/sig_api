package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CertifdicadoTipoDTO {
	
   private Long id;
	
	private String nombre;

	private String descripcion;

	private Date fecha;


}
