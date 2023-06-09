package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.Institucion;
import ec.edu.insteclrg.sig_api.dto.InstitucionDTO;
import ec.edu.insteclrg.sig_api.persistence.InstitucionPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class InstitucionService extends GenericCrudServiceImpl<Institucion, InstitucionDTO> {

	@Autowired 
	private InstitucionPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Institucion> find(InstitucionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Institucion mapToDomain(InstitucionDTO dto) {
		return modelMapper.map(dto, Institucion.class);
	}

	@Override
	public InstitucionDTO mapToDto(Institucion domain) {
		return modelMapper.map(domain, InstitucionDTO.class);
	}

}
