 package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.Rol;
import ec.edu.insteclrg.sig_api.dto.administracion.RolDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.RolPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class RolService extends GenericCrudServiceImpl<Rol, RolDTO> {

	@Autowired
	private RolPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Rol> find(RolDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Rol mapToDomain(RolDTO dto) {
		return modelMapper.map(dto, Rol.class);
	}

	@Override
	public RolDTO mapToDto(Rol domain) {
		return modelMapper.map(domain, RolDTO.class);
	}


	
}
