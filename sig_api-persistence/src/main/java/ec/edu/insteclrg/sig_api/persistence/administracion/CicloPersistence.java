package ec.edu.insteclrg.sig_api.persistence.administracion;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.insteclrg.sig_api.domain.administracion.Ciclo;


public interface CicloPersistence extends JpaRepository<Ciclo, Long>{
	
}
