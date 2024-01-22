package ec.edu.insteclrg.sig_api.service.talentohumano;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.talentohumano.Docente;
import ec.edu.insteclrg.sig_api.dto.talentohumano.DocenteDTO;
import ec.edu.insteclrg.sig_api.persistence.talentohumano.DocenterPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class DocenteService extends GenericCrudServiceImpl<Docente, DocenteDTO>{

	@Autowired
	private DocenterPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Docente> find(DocenteDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Docente mapToDomain(DocenteDTO dto) {
		return modelMapper.map(dto, Docente.class);
	}

	@Override
	public DocenteDTO mapToDto(Docente domain) {
		return modelMapper.map(domain, DocenteDTO.class);
	}

}
