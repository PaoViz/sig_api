package ec.edu.insteclrg.sig_api.service.administracion;



import java.util.Optional;

import ec.edu.insteclrg.sig_api.domain.administracion.GrupoOcupacional;
import ec.edu.insteclrg.sig_api.dto.administracion.GrupoOcupacionalDTO;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

public class GrupoOcupacionalService  extends GenericCrudServiceImpl<GrupoOcupacional, GrupoOcupacionalDTO> {

	@Override
	public Optional<GrupoOcupacional> find(GrupoOcupacionalDTO dto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public GrupoOcupacional mapToDomain(GrupoOcupacionalDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoOcupacionalDTO mapToDto(GrupoOcupacional domain) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
