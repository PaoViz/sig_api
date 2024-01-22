package ec.edu.insteclrg.sig_api.dto.vinculacion;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.dto.talentohumano.DocenteDTO;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class ProyectoDTO {
	
	private Long id;
	
	private String descripcion;
	
	private Date fechainicio;
	
	private Date fechafin;
	
	private DocenteDTO docenteGestor;

} 
