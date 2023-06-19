package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.Parroquia;
import ec.edu.insteclrg.sig_api.dto.administracion.ParroquiaDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.ParroquiaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class ParroquiaService extends GenericCrudServiceImpl<Parroquia, ParroquiaDTO> {
	
	@Autowired
	private ParroquiaPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Parroquia> find(ParroquiaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Parroquia mapToDomain(ParroquiaDTO dto) {

		return modelMapper.map(dto, Parroquia.class);
	}

	@Override
	public ParroquiaDTO mapToDto(Parroquia domain) {
		return modelMapper.map(domain, ParroquiaDTO.class);
	}
	
	

}
