package ec.edu.insteclrg.sig_api.persistence.administracion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.administracion.GestionDocumentalDocumento;

public interface GestionDocumentalDocumentoPersistence extends JpaRepository<GestionDocumentalDocumento, Long>{
	
	Optional<GestionDocumentalDocumento> findByCodigo(String codigo);
}
