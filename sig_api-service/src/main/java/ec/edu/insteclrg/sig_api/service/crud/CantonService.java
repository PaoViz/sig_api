package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.Canton;
import ec.edu.insteclrg.sig_api.dto.CantonDTO;
import ec.edu.insteclrg.sig_api.persistence.CantonPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class CantonService extends GenericCrudServiceImpl<Canton, CantonDTO>{
	
	@Autowired
	private CantonPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Canton> buscar(CantonDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Canton mapToDomain(CantonDTO dto) {
		return modelMapper.map(dto, Canton.class);
	}

	@Override
	public CantonDTO mapToDto(Canton domain) {
		return modelMapper.map(domain, CantonDTO.class);
	}

}
