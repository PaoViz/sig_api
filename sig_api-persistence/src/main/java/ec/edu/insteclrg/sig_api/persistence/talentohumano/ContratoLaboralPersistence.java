package ec.edu.insteclrg.sig_api.persistence.talentohumano;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.talentohumano.ContratoLaboral;

public interface ContratoLaboralPersistence extends JpaRepository<ContratoLaboral, Long>{

}