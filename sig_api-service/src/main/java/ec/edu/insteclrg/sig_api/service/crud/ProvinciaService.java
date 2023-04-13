package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.Provincia;
import ec.edu.insteclrg.sig_api.dto.ProvinciaDTO;
import ec.edu.insteclrg.sig_api.persistence.ProvinciaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class ProvinciaService extends GenericCrudServiceImpl<Provincia, ProvinciaDTO> {

	@Autowired
	private ProvinciaPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Provincia> buscar(ProvinciaDTO dto) {
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
