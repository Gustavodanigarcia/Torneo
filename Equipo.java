public class Equipo {

	
	private int id;
	private String nombre;
	private int puntosEnTorneo;
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	
	

		public Equipo(int id, String nombre) {
			
			this.id = id;
			this.nombre = nombre;
		}

		
		
		
		
		public int getPartidosGanados() {
			return partidosGanados;
		}

		public void setPartidosGanados(int partidosGanados) {
			this.partidosGanados = partidosGanados;
		}


		public int getPartidosEmpatados() {
			return partidosEmpatados;
		}





		public void setPartidosEmpatados(int partidosEmpatados) {
			this.partidosEmpatados = partidosEmpatados;
		}





		public int getPartidosPerdidos() {
			return partidosPerdidos;
		}





		public void setPartidosPerdidos(int partidosPerdidos) {
			this.partidosPerdidos = partidosPerdidos;
		}





	public int getPuntos() {
		return puntosEnTorneo;
	}

	public void setPuntos(int puntos) {
		this.puntosEnTorneo = puntos;
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

