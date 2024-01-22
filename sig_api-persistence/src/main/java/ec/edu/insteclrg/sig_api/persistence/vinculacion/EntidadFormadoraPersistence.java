package ec.edu.insteclrg.sig_api.persistence.vinculacion;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.vinculacion.EntidadFormadora;



public interface EntidadFormadoraPersistence extends JpaRepository<EntidadFormadora, Long> {

}
