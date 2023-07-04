package ec.edu.insteclrg.sig_api.dto.administracion;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class CertifdicadoTipoDTO {
	
   private Long id;
	
	private String nombre;

	private String descripcion;

	private Date fecha;


}
