package ec.edu.insteclrg.sig_api.dto.administracion;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonaDTO {
	
	private Long id;
	
	private Tipo_IdentificacionDTO tipoIdentificacion;
	
	private String numeroIdentificacion;

	private String primerApellido;

	private String segundoApellido;

	private String primerNombre;

	private String segundoNombre;
	
	private SexoDTO sexo;
	
	private GeneroDTO genero;
	
	private EstadoCivilDTO estadoCivil;
	
	private TipoSangreDTO tipoSangre;
	
	private Date fechaNacimiento;
	
	private ParroquiaDTO parroquia;
	
	private String callePrincipal;

	private String calleSecundaria;

	private String referencia;

	private PaisDTO paisNacionalidad;
	
	private String telefonoDomicilio;

	private String telefonoCelular;

	private String correoPersonal;

	private String correoInstitucional;

	private TipoDiscapacidadDTO tipoDiscapacidad;
	
	private String NroCarnetDiscapacidad;

	private Float porcentajeDiscapacidad;

	private EtniaDTO etnia;
	
	private PuebloNacionalidadDTO puebloNacionalidad;
	
	private TipoEnfermedadCatastroficaDTO tipoEnfermedadCatastrofica;
	
	private NivelInstruccionDTO nivelInstruccion;
	
	private UsuarioDTO usuario;
}
