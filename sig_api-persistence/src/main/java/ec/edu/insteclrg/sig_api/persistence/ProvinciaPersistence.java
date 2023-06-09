package ec.edu.insteclrg.sig_api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.Provincia;

public interface ProvinciaPersistence extends JpaRepository<Provincia, Long> {

}
