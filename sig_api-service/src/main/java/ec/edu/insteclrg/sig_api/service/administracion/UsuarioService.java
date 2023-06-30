package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.administracion.Usuario;
import ec.edu.insteclrg.sig_api.dto.administracion.UsuarioDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.UsuarioPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;
import jakarta.validation.Valid;

@Service
public class UsuarioService extends GenericCrudServiceImpl<Usuario, UsuarioDTO>{

	@Autowired
	private UsuarioPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Usuario> find(UsuarioDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Usuario mapToDomain(UsuarioDTO dto) {
		return modelMapper.map(dto, Usuario.class);
	}

	@Override
	public UsuarioDTO mapToDto(Usuario domain) {
		return modelMapper.map(domain, UsuarioDTO.class);
	}

	public Optional<Usuario> buscarPorUsername(String username) {
		Optional<Usuario> entidad = repository.findByUsername(username);
				if (entidad.isEmpty())
					throw new ApiException(String.format("Registros con el username %s no existe en el sistema", username));
		return entidad;
	}
	


}
