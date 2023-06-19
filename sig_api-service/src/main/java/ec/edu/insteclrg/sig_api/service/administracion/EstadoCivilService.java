package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.EstadoCivil;
import ec.edu.insteclrg.sig_api.dto.administracion.EstadoCivilDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.EstadoCivilPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class EstadoCivilService extends GenericCrudServiceImpl<EstadoCivil, EstadoCivilDTO> {

	@Autowired
	private EstadoCivilPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper(); 
	
	@Override
	public Optional<EstadoCivil> find(EstadoCivilDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public EstadoCivil mapToDomain(EstadoCivilDTO dto) {
		return modelMapper.map(dto, EstadoCivil.class);
	}

	@Override
	public EstadoCivilDTO mapToDto(EstadoCivil domain) {
		return modelMapper.map(domain, EstadoCivilDTO.class);
	}

}
