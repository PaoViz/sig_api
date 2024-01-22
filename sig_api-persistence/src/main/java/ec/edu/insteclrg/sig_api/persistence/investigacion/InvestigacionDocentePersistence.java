package ec.edu.insteclrg.sig_api.persistence.investigacion;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.investigacion.InvestigacionDocente;

public interface InvestigacionDocentePersistence extends JpaRepository<InvestigacionDocente, Long>{

}
