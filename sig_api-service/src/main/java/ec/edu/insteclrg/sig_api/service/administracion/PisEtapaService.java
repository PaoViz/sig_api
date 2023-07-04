package ec.edu.insteclrg.sig_api.service.administracion;


import java.util.Optional;

import ec.edu.insteclrg.sig_api.domain.administracion.PisEtapa;
import ec.edu.insteclrg.sig_api.dto.administracion.PisEtapaDTO;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

public class PisEtapaService extends GenericCrudServiceImpl<PisEtapa, PisEtapaDTO> {

    @Override
    public Optional<PisEtapa> find(PisEtapaDTO dto) {
        return Optional.empty();
    }

    @Override
    public PisEtapa mapToDomain(PisEtapaDTO dto) {
        return null;
    }

	@Override
	public PisEtapaDTO mapToDto(PisEtapa domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
