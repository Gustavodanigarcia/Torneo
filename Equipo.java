

public class Equipo {

	
	private int id;
	private String nombre;

	private int puntos;
	
	public Equipo(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}


	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Equipo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
