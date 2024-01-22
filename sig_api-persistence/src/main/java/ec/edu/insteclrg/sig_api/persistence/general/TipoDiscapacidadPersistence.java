package ec.edu.insteclrg.sig_api.persistence.general;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.general.TipoDiscapacidad;

public interface TipoDiscapacidadPersistence extends JpaRepository<TipoDiscapacidad, Long> {
	

}
