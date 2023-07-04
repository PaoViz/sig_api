package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ec.edu.insteclrg.sig_api.domain.administracion.Periodo;
import ec.edu.insteclrg.sig_api.dto.administracion.PeriodoDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.PeriodoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class PeriodoService extends GenericCrudServiceImpl<Periodo, PeriodoDTO>{

	@Autowired
	private PeriodoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Periodo> find(PeriodoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Periodo mapToDomain(PeriodoDTO dto) {
		return modelMapper.map(dto, Periodo.class);
	}

	@Override
	public PeriodoDTO mapToDto(Periodo domain) {
		return modelMapper.map(domain, PeriodoDTO.class);
	}

}
