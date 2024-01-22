package ec.edu.insteclrg.sig_api.dto.general;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NivelInstruccionDTO {

	private Long id;

    private String descripcion;
}

