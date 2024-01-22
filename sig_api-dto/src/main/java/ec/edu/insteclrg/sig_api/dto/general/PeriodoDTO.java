package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PeriodoDTO {
	
    private Long id;

    private String descripcion;
    
	private Date fechaInicio;
    
	private Date fechaFin;
    
    private Boolean activo;

}
