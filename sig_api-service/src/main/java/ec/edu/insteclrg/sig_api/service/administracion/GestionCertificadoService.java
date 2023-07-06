package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.GestionCertificado;
import ec.edu.insteclrg.sig_api.dto.administracion.GestionCertificadoDTO;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;


@Service
public class GestionCertificadoService extends GenericCrudServiceImpl<GestionCertificado, GestionCertificadoDTO>{

	@Override
	public Optional<GestionCertificado> find(GestionCertificadoDTO dto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public GestionCertificado mapToDomain(GestionCertificadoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GestionCertificadoDTO mapToDto(GestionCertificado domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
