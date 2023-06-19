package ec.edu.insteclrg.sig_api.persistence.administracion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.administracion.Pais;

public interface PaisPersistence extends JpaRepository<Pais, Long> {

	Optional<Pais> findByCodigo(String codigo);
}
