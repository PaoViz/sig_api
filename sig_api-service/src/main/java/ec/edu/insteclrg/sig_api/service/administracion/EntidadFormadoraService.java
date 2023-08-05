package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.sig_api.domain.administracion.EntidadFormadora;
import ec.edu.insteclrg.sig_api.dto.administracion.EntidadFormadoraDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.EntidadFormadoraPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class EntidadFormadoraService extends GenericCrudServiceImpl<EntidadFormadora, EntidadFormadoraDTO> {

	@Autowired
	private EntidadFormadoraPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<EntidadFormadora> find(EntidadFormadoraDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public EntidadFormadora mapToDomain(EntidadFormadoraDTO dto) {
		return modelMapper.map(dto, EntidadFormadora.class);
	}

	@Override
	public EntidadFormadoraDTO mapToDto(EntidadFormadora domain) {
		return modelMapper.map(domain, EntidadFormadoraDTO.class);
	}
}
