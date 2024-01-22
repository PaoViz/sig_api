package ec.edu.insteclrg.sig_api.domain.certificado;

import java.sql.Date;

import ec.edu.insteclrg.sig_api.domain.general.CertificadoTipo;
import ec.edu.insteclrg.sig_api.domain.general.Persona;
import ec.edu.insteclrg.sig_api.domain.general.Usuario;
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
@Table(name = "gestion_certificado")
public class GestionCertificado {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column()
    private Date fechaCreacion;

    @Column()
    private String titulo;

    @Column()
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_certificado_tipo")
    private CertificadoTipo certificadoTipo;

    
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}
