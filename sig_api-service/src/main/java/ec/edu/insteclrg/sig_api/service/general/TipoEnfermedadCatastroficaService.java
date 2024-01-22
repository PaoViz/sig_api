package ec.edu.insteclrg.sig_api.service.general;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.general.TipoEnfermedadCatastrofica;
import ec.edu.insteclrg.sig_api.dto.general.TipoEnfermedadCatastroficaDTO;
import ec.edu.insteclrg.sig_api.persistence.general.TipoEnfermedadCatastroficaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class TipoEnfermedadCatastroficaService extends GenericCrudServiceImpl<TipoEnfermedadCatastrofica, TipoEnfermedadCatastroficaDTO> {

	@Autowired
	private TipoEnfermedadCatastroficaPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<TipoEnfermedadCatastrofica> find(TipoEnfermedadCatastroficaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoEnfermedadCatastrofica mapToDomain(TipoEnfermedadCatastroficaDTO dto) {
		return modelMapper.map(dto, TipoEnfermedadCatastrofica.class);
	}

	@Override
	public TipoEnfermedadCatastroficaDTO mapToDto(TipoEnfermedadCatastrofica domain) {
		return modelMapper.map(domain, TipoEnfermedadCatastroficaDTO.class);
	}

}
