package ec.edu.insteclrg.sig_api.persistence.gestiondocumental;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.gestiondocumental.GestionDocumentalDocumento;

public interface GestionDocumentalDocumentoPersistence extends JpaRepository<GestionDocumentalDocumento, Long>{
	
	Optional<GestionDocumentalDocumento> findByCodigo(String codigo);
}
