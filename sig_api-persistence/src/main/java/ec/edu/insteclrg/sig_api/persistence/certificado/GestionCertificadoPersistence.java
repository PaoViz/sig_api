package ec.edu.insteclrg.sig_api.persistence.certificado;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.certificado.GestionCertificado;


public interface GestionCertificadoPersistence  extends JpaRepository<GestionCertificado, Long>{

}


