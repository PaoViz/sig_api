package ec.edu.insteclrg.sig_api.persistence.general;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.general.Carrera;




public interface CarreraPersistence extends JpaRepository<Carrera, Long> {

	Optional<Carrera> findByCodigo(String codigo);
}
