package ec.edu.insteclrg.sig_api.domain.general;

import java.sql.Date;

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
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tipoIdentificacion_id")
	private TipoIdentificacion tipoIdentificacion;
	
	@Column(nullable = false)
	private String numeroIdentificacion;
	
	@Column(nullable = false)
	private String primerApellido;
	
	@Column
	private String segundoApellido;
	
	@Column(nullable = false)
	private String primerNombre;
	
	@Column
	private String segundoNombre;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private Sexo sexo;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private Genero genero;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private EstadoCivil estadoCivil;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private TipoSangre tipoSangre;
	
	@Column(nullable = false)
	private Date fechaNacimiento;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private Parroquia parroquia;
	
	@Column(nullable = false)
	private String callePrincipal;
	
	@Column
	private String calleSecundaria;
	
	@Column
	private String referencia;
	
	//@ManyToOne(cascade = CascadeType.ALL, optional = false)
	//@JoinColumn
	//private Pais paisNacionalidad;
	
	@Column
	private String telefonoDomicilio;
	
	@Column(nullable = false)
	private String telefonoCelular;
	
	@Column(nullable = false)
	private String correoPersonal;
	
	@Column
	private String correoInstitucional;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn
	private TipoDiscapacidad tipoDiscapacidad;
	
	@Column
	private String NroCarnetDiscapacidad;
	
	@Column
	private Float porcentajeDiscapacidad;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn
	private Etnia etnia;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn
	private PuebloNacionalidad puebloNacionalidad;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn
	private TipoEnfermedadCatastrofica tipoEnfermedadCatastrofica;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn
	private NivelInstruccion nivelInstruccion;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn
	private Usuario usuario;
	
	

}
