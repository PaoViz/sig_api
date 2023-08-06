package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.GestionDocumentalDocumento;
import ec.edu.insteclrg.sig_api.domain.administracion.ProyectoVinculacionPlanificacion;
import ec.edu.insteclrg.sig_api.dto.administracion.GestionDocumentalDocumentoDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.ProyectoVinculacionPlanificacionDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.ProyectoVinculacionPlanificacionPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class ProyectoVinculacionPlanificacionService extends GenericCrudServiceImpl<ProyectoVinculacionPlanificacion, ProyectoVinculacionPlanificacionDTO>{

	@Autowired
	private ProyectoVinculacionPlanificacionPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<ProyectoVinculacionPlanificacion> find(ProyectoVinculacionPlanificacionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ProyectoVinculacionPlanificacion mapToDomain(ProyectoVinculacionPlanificacionDTO dto) {
		return modelMapper.map(dto, ProyectoVinculacionPlanificacion.class);
	}

	@Override
	public ProyectoVinculacionPlanificacionDTO mapToDto(ProyectoVinculacionPlanificacion domain) {
		return modelMapper.map(domain, ProyectoVinculacionPlanificacionDTO.class);
	}

}
