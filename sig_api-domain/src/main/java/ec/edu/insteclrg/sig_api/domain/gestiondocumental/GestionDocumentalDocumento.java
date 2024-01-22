package ec.edu.insteclrg.sig_api.domain.gestiondocumental;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.domain.general.Periodo;
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
@Table(name = "gestiondocumentaldocumento")
public class GestionDocumentalDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false, unique = true)
	private String codigo;
	
	@Column(nullable = false, unique = true)
	private String titulo;
	
	@Column()
	private Date fechaCreacion;
	
	@Column()
	private String url;
	
	@Column(nullable = false, unique = true)
	private String observacion;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "periodo_id")
	private Periodo periodo;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "gestionDocumental_id")
	private GestionDocumental gestionDocumental;

}
