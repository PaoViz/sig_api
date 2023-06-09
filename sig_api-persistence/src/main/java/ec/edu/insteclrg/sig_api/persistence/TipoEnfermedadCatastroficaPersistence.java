package ec.edu.insteclrg.sig_api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.TipoEnfermedadCatastrofica;

public interface TipoEnfermedadCatastroficaPersistence extends JpaRepository<TipoEnfermedadCatastrofica, Long> {

}
