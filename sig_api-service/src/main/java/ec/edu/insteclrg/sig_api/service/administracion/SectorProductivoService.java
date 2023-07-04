package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.SectorProductivo;
import ec.edu.insteclrg.sig_api.dto.administracion.SectorProductivoDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.SectorProductivoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class SectorProductivoService extends GenericCrudServiceImpl<SectorProductivo, SectorProductivoDTO> {

	@Autowired
	private SectorProductivoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<SectorProductivo> find(SectorProductivoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public SectorProductivo mapToDomain(SectorProductivoDTO dto) {
		return modelMapper.map(dto,SectorProductivo.class);
	}

	@Override
	public SectorProductivoDTO mapToDto(SectorProductivo domain) {
		return modelMapper.map(domain,SectorProductivoDTO.class);
	}

}
