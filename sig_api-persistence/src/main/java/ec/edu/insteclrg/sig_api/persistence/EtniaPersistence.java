package ec.edu.insteclrg.sig_api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.Etnia;

public interface EtniaPersistence  extends JpaRepository<Etnia, Long>{

}
