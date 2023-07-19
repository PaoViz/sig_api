package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class ProyectoDTO {
	
private String descripcion;
	
	private Date fechainicio;
	
	private Date fechafin;
	
	private DocenteDTO docenteGestor;
} 
