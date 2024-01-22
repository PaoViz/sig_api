package ec.edu.insteclrg.sig_api.service.general;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.general.Persona;
import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
import ec.edu.insteclrg.sig_api.persistence.general.PersonaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class PersonaService extends GenericCrudServiceImpl<Persona, PersonaDTO> {

	@Autowired
	private PersonaPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Persona> find(PersonaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Persona mapToDomain(PersonaDTO dto) {
		return modelMapper.map(dto, Persona.class);
	}

	@Override
	public PersonaDTO mapToDto(Persona domain) {
		return modelMapper.map(domain, PersonaDTO.class);
	}

	public Optional<Persona> buscarPorNumeroIdentificacion(String numeroIdentificacio) {
		Optional<Persona> entidad = repository.findByNumeroIdentificacion(numeroIdentificacio);
		if(entidad.isEmpty())
			throw new ApiException(String.format("Registro con la Identificacion %s no existe en el sitema",numeroIdentificacio));
		return entidad;
	}
	
	
	

}
