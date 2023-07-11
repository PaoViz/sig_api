package ec.edu.insteclrg.sig_api.domain.administracion;


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
public class Docente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
	
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "persona_id")
    private Persona persona;
    
    @Column(nullable = false)
    private Boolean activo;
}
