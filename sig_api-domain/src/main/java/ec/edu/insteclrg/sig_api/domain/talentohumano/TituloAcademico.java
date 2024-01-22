package ec.edu.insteclrg.sig_api.domain.talentohumano;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.domain.general.Persona;
import ec.edu.insteclrg.sig_api.domain.general.TipoTituloAcademico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TituloAcademico {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "persona_id")
    private Persona persona;
	
	@Column(nullable = false, unique = true)
	private String descripcion;
	
	@Column(nullable = false, unique = true)
	private String numeroRegistro;
	
    @Column()
	private Date fechaRegistroTitulo;
    
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tituloAcademico_id")
    private TipoTituloAcademico tipoTituloAcademico;
    
    
}
