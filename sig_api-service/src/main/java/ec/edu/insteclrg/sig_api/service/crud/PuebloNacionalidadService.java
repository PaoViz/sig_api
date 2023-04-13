package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.PuebloNacionalidad;
import ec.edu.insteclrg.sig_api.dto.PuebloNacionalidadDTO;
import ec.edu.insteclrg.sig_api.persistence.PuebloNacionalidadPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class PuebloNacionalidadService extends GenericCrudServiceImpl<PuebloNacionalidad, PuebloNacionalidadDTO>{

	@Autowired
	private PuebloNacionalidadPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<PuebloNacionalidad> buscar(PuebloNacionalidadDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public PuebloNacionalidad mapToDomain(PuebloNacionalidadDTO dto) {
		return modelMapper.map(dto, PuebloNacionalidad.class);
	}

	@Override
	public PuebloNacionalidadDTO mapToDto(PuebloNacionalidad domain) {
		return modelMapper.map(domain, PuebloNacionalidadDTO.class);
	}

}
