package ec.edu.insteclrg.sig_api.domain.administracion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity

public class EmpresaFormadora {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
	@Column(updatable = false, nullable = false)
	 private Long ruc;
    @Column(nullable = false)
    private String descripcion;
}
