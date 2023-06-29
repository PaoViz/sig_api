package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.administracion.NivelInstruccion;
import ec.edu.insteclrg.sig_api.domain.administracion.Pais;
import ec.edu.insteclrg.sig_api.dto.administracion.NivelInstruccionDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.NivelInstruccionPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class NivelInstruccionService extends GenericCrudServiceImpl<NivelInstruccion, NivelInstruccionDTO>{

	@Autowired
	private NivelInstruccionPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<NivelInstruccion> find(NivelInstruccionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public NivelInstruccion mapToDomain(NivelInstruccionDTO dto) {
		return modelMapper.map(dto, NivelInstruccion.class);
	}

	@Override
	public NivelInstruccionDTO mapToDto(NivelInstruccion domain) {
		return modelMapper.map(domain, NivelInstruccionDTO.class);
	}


}
