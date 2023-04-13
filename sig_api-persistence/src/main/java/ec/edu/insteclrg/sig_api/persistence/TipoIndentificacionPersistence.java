package ec.edu.insteclrg.sig_api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.sig_api.domain.Tipo_Identificacion;

@Repository
public interface TipoIndentificacionPersistence extends JpaRepository<Tipo_Identificacion, Long> {

}
