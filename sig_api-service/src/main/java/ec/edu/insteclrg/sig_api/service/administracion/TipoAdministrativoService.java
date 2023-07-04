package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import ec.edu.insteclrg.sig_api.domain.administracion.TipoAdministrativo;
import ec.edu.insteclrg.sig_api.dto.administracion.TipoAdministrativoDTO;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

public class TipoAdministrativoService  extends GenericCrudServiceImpl<TipoAdministrativo, TipoAdministrativoDTO> {

	@Override
	public Optional<TipoAdministrativo> find(TipoAdministrativoDTO dto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public TipoAdministrativo mapToDomain(TipoAdministrativoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoAdministrativoDTO mapToDto(TipoAdministrativo domain) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
