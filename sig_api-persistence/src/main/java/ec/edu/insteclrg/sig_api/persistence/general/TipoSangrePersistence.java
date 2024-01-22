package ec.edu.insteclrg.sig_api.persistence.general;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.general.TipoSangre;

public interface TipoSangrePersistence extends JpaRepository<TipoSangre, Long>{

}
