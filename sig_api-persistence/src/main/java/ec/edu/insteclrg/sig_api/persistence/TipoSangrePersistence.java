package ec.edu.insteclrg.sig_api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.TipoSangre;

public interface TipoSangrePersistence extends JpaRepository<TipoSangre, Long>{

}
