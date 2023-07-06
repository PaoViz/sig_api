package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import ec.edu.insteclrg.sig_api.domain.administracion.EmpresaFormadora;
import ec.edu.insteclrg.sig_api.dto.administracion.EmpresaFormadoraDTO;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

public class EmpresaFormadoraService extends GenericCrudServiceImpl<EmpresaFormadora, EmpresaFormadoraDTO> {

	@Override
	public Optional<EmpresaFormadora> find(EmpresaFormadoraDTO dto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public EmpresaFormadora mapToDomain(EmpresaFormadoraDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpresaFormadoraDTO mapToDto(EmpresaFormadora domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
