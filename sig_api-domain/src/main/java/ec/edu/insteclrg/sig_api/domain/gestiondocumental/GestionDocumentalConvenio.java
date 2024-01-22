package ec.edu.insteclrg.sig_api.domain.gestiondocumental;

import java.sql.Date;
import java.util.Set;

import ec.edu.insteclrg.sig_api.domain.general.Carrera;
import ec.edu.insteclrg.sig_api.domain.general.TipoConvenio;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gestionDocumentalConvenio")
public class GestionDocumentalConvenio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tipoConvenio_id")
	private TipoConvenio tipoConvenio;
	
	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private String url;
	
	@Column(nullable = false)
	private Date fechaInicio;
	
	@Column(nullable = false)
	private Date fechaFin;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "gestionDocumental_id")
	private GestionDocumental gestionDocumental;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "gestionDocumentalConvenio_carrera", 
	joinColumns = @JoinColumn(name = "gestionDocumentalConvenio_id"), 
	inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	private Set<Carrera> carrera;


	
	

}
