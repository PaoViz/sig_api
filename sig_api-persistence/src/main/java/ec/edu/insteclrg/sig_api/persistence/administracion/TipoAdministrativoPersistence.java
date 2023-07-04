package ec.edu.insteclrg.sig_api.persistence.administracion;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.insteclrg.sig_api.domain.administracion.TipoAdministrativo;

public interface TipoAdministrativoPersistence extends JpaRepository<TipoAdministrativo, Long> {
 
}
