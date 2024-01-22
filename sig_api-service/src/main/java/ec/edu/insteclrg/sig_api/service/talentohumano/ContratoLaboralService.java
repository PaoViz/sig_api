package ec.edu.insteclrg.sig_api.service.talentohumano;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.talentohumano.ContratoLaboral;
import ec.edu.insteclrg.sig_api.dto.talentohumano.ContratoLaboralDTO;
import ec.edu.insteclrg.sig_api.persistence.talentohumano.ContratoLaboralPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class ContratoLaboralService extends GenericCrudServiceImpl<ContratoLaboral, ContratoLaboralDTO>{
	
	@Autowired
	private ContratoLaboralPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<ContratoLaboral> find(ContratoLaboralDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ContratoLaboral mapToDomain(ContratoLaboralDTO dto) {
		return modelMapper.map(dto, ContratoLaboral.class);
	}

	@Override
	public ContratoLaboralDTO mapToDto(ContratoLaboral domain) {
		return modelMapper.map(domain, ContratoLaboralDTO.class);
	}

}
