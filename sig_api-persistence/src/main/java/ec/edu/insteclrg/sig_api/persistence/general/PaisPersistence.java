package ec.edu.insteclrg.sig_api.persistence.general;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.general.Pais;

public interface PaisPersistence extends JpaRepository<Pais, Long> {

	Optional<Pais> findByCodigo(String codigo);
}
