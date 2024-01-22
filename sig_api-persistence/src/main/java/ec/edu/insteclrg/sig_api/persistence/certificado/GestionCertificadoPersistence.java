package ec.edu.insteclrg.sig_api.persistence.administracion;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.insteclrg.sig_api.domain.administracion.GestionCertificado;


public interface GestionCertificadoPersistence  extends JpaRepository<GestionCertificado, Long>{

}


