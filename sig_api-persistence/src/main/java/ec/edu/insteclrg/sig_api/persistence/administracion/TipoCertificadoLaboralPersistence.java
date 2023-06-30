package ec.edu.insteclrg.sig_api.persistence.administracion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.administracion.TipoCertificadoLaboral;

public interface TipoCertificadoLaboralPersistence extends JpaRepository<TipoCertificadoLaboral, Long>{


}
