package ec.edu.insteclrg.sig_api.persistence.general;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.general.Usuario;

public interface UsuarioPersistence extends JpaRepository< Usuario, Long> {

	Optional<Usuario> findByUsername(String username );
	


}
