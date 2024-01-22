package ec.edu.insteclrg.sig_api.service.certificado;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.certificado.GestionCertificado;
import ec.edu.insteclrg.sig_api.dto.certificado.GestionCertificadoDTO;
import ec.edu.insteclrg.sig_api.persistence.certificado.GestionCertificadoPersistence;
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
