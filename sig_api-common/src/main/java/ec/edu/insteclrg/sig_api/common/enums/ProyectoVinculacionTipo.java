package ec.edu.insteclrg.sig_api.common.enums;

public enum ProyectoVinculacionTipo {
	
	VINCULACION(1,"Vinculación"), 
	ACTIVIDADDEVINCULACIÓN(2,"Actividad de Vinculación");

	private int id;
	private String description;

	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}

	private ProyectoVinculacionTipo(int id, String descripcion) {
		this.id=id;
		this.description = descripcion;
	}
}
