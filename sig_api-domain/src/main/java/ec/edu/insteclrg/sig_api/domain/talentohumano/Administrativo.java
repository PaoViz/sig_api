package ec.edu.insteclrg.sig_api.domain.talentohumano;

import ec.edu.insteclrg.sig_api.domain.general.Persona;
import ec.edu.insteclrg.sig_api.domain.general.TipoAdministrativo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "administrativo")
public class Administrativo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "persona_id")
	private Persona persona;
	

	@Column
	private Boolean activo;
	
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tipo_administrativo_id")
	private TipoAdministrativo tipo_administrativo;
	
	
	
	
}
