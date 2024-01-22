package ec.edu.insteclrg.sig_api.persistence.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.sig_api.domain.usuario.Rol;

public interface RolPersistence extends JpaRepository<Rol, Long>{
	
}
