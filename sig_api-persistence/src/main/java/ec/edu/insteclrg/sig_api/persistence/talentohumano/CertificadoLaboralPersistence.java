package ec.edu.insteclrg.sig_api.persistence.talentohumano;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.talentohumano.CertificadoLaboral;

public interface CertificadoLaboralPersistence extends JpaRepository<CertificadoLaboral, Long> {

}
