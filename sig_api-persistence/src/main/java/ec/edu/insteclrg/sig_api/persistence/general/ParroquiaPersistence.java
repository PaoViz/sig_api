package ec.edu.insteclrg.sig_api.persistence.general;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.general.Parroquia;

public interface ParroquiaPersistence extends JpaRepository<Parroquia, Long> {

}
