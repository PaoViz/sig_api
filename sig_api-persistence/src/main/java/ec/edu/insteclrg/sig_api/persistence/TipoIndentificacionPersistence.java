package ec.edu.insteclrg.sig_api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.Tipo_Identificacion;

public interface TipoIndentificacionPersistence extends JpaRepository<Tipo_Identificacion, Long> {

}
