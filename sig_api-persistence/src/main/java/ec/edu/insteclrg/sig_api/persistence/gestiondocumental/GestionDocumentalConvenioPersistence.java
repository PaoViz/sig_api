package ec.edu.insteclrg.sig_api.persistence.gestiondocumental;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.gestiondocumental.GestionDocumentalConvenio;

public interface GestionDocumentalConvenioPersistence extends JpaRepository<GestionDocumentalConvenio, Long>{

}
