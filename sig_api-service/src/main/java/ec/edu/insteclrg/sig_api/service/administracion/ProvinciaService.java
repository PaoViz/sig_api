package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.Provincia;
import ec.edu.insteclrg.sig_api.dto.administracion.ProvinciaDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.ProvinciaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class ProvinciaService extends GenericCrudServiceImpl<Provincia, ProvinciaDTO> {

	@Autowired
	private ProvinciaPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Provincia> find(ProvinciaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Provincia mapToDomain(ProvinciaDTO dto) {
		return modelMapper.map(dto, Provincia.class);
	}

	@Override
	public ProvinciaDTO mapToDto(Provincia domain) {
		return modelMapper.map(domain, ProvinciaDTO.class);
	}

}
