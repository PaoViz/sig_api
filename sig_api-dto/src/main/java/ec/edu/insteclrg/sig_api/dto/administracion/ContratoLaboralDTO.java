package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ContratoLaboralDTO {
	
	private Long id;
	
	private PersonaDTO persona;
	
	private ModalidadContratoDTO modalidad_contrato;
	
	private CargoDTO cargo;
	
	private GrupoOcupacionalDTO grupo_ocupacional;
	
	private Float renumeracion;
	
	private Date fecha_ingreso;
	
	private Date fecha_salida;
	
	private Byte documento;
	
}