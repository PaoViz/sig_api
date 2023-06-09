package ec.edu.insteclrg.sig_api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.Institucion;

public interface InstitucionPersistence extends JpaRepository<Institucion, Long> {

}
