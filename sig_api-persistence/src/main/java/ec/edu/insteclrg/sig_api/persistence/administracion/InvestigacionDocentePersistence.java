package ec.edu.insteclrg.sig_api.persistence.administracion;

import org.springframework.data.jpa.repository.JpaRepository;


import ec.edu.insteclrg.sig_api.domain.administracion.InvestigacionDocente;

public interface InvestigacionDocentePersistence extends JpaRepository<InvestigacionDocente, Long>{

}
