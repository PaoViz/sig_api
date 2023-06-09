package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.Sexo;
import ec.edu.insteclrg.sig_api.dto.SexoDTO;
import ec.edu.insteclrg.sig_api.persistence.SexoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class SexoService extends GenericCrudServiceImpl<Sexo, SexoDTO> {

	@Autowired
	private SexoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Sexo> find(SexoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Sexo mapToDomain(SexoDTO dto) {
		return modelMapper.map(dto, Sexo.class);
	}

	@Override
	public SexoDTO mapToDto(Sexo domain) {
		return modelMapper.map(domain, SexoDTO.class);
	}

}
