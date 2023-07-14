package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.sig_api.domain.administracion.GestionCertificado;
import ec.edu.insteclrg.sig_api.dto.administracion.GestionCertificadoDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.GestionCertificadoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;


@Service
public class GestionCertificadoService extends GenericCrudServiceImpl<GestionCertificado, GestionCertificadoDTO>{

	@Autowired
	private GestionCertificadoPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<GestionCertificado> find(GestionCertificadoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public GestionCertificado mapToDomain(GestionCertificadoDTO dto) {
		return modelMapper.map(dto, GestionCertificado.class);
	}

	@Override
	public GestionCertificadoDTO mapToDto(GestionCertificado domain) {
		return modelMapper.map(domain, GestionCertificadoDTO.class);
	}

}
