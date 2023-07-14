package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.TituloAcademico;
import ec.edu.insteclrg.sig_api.dto.administracion.TituloAcademicoDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.TituloAcademicoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class TituloAcademicoService extends GenericCrudServiceImpl<TituloAcademico, TituloAcademicoDTO>{

	@Autowired
	private TituloAcademicoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<TituloAcademico> find(TituloAcademicoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TituloAcademico mapToDomain(TituloAcademicoDTO dto) {
		return modelMapper.map(dto, TituloAcademico.class);
	}

	@Override
	public TituloAcademicoDTO mapToDto(TituloAcademico domain) {
		return modelMapper.map(domain, TituloAcademicoDTO.class);
	}

}
