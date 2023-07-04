package ec.edu.insteclrg.sig_api.domain.administracion;

import ec.edu.insteclrg.sig_api.domain.general.Persona;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Persona persona;
}