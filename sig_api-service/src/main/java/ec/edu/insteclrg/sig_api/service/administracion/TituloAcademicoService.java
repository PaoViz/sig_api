package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.TituloAcademico;
import ec.edu.insteclrg.sig_api.dto.administracion.TituloAcademicoDTO;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class TituloAcademicoService extends GenericCrudServiceImpl<TituloAcademico, TituloAcademicoDTO> {
	

	@Override
	public Optional<TituloAcademico> find(TituloAcademicoDTO dto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public TituloAcademico mapToDomain(TituloAcademicoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TituloAcademicoDTO mapToDto(TituloAcademico domain) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
