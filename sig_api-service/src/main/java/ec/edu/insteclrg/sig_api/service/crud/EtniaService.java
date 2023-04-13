package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.Etnia;
import ec.edu.insteclrg.sig_api.dto.EtniaDTO;
import ec.edu.insteclrg.sig_api.persistence.EtniaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class EtniaService extends GenericCrudServiceImpl<Etnia, EtniaDTO> {

	@Autowired
	private EtniaPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Etnia> buscar(EtniaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Etnia mapToDomain(EtniaDTO dto) {
		return modelMapper.map(dto, Etnia.class);
	}

	@Override
	public EtniaDTO mapToDto(Etnia domain) {
		return modelMapper.map(domain, EtniaDTO.class);
	}

}
