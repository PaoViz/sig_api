package ec.edu.insteclrg.sig_api.service.usuario;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.usuario.RolUsuario;
import ec.edu.insteclrg.sig_api.dto.usuario.RolUsuarioDTO;
import ec.edu.insteclrg.sig_api.persistence.usuario.RolUsuarioPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class RolUsuarioService extends GenericCrudServiceImpl<RolUsuario, RolUsuarioDTO> {

	@Autowired
	private RolUsuarioPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();


	public Optional<RolUsuario> find(RolUsuarioDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public RolUsuario mapToDomain(RolUsuarioDTO dto) {
		return modelMapper.map(dto, RolUsuario.class);
	}

	@Override
	public RolUsuarioDTO mapToDto(RolUsuario domain) {
		return modelMapper.map(domain, RolUsuarioDTO.class);
	}

}
