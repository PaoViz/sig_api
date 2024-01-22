package ec.edu.insteclrg.sig_api.dto.talentohumano;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.dto.general.CargoDTO;
import ec.edu.insteclrg.sig_api.dto.general.GrupoOcupacionalDTO;
import ec.edu.insteclrg.sig_api.dto.general.ModalidadContratoDTO;
import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
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