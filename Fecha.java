import java.util.ArrayList;
import java.util.List;

public class Fecha {

	
private List<Partido> partidos = new ArrayList<>();
	
	private int IdFecha;   //Cada Fecha es unica::::
	
	private int IdCampeonato;  //Cada Fecha va a tener un ID campeonato para relacionarlo al campeonato para futuras busquedas:::


	//Get y Set de ID Fecha::::
	public int getIdFecha() {
		return IdFecha;
	}
	
	public void setIdFecha(int idFecha) {
		IdFecha = idFecha;
	}
	
	
	//Get y Set de Todos los Partidos::::
	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

//Get y set del ID Campeonato::::
	public int getIdCampeonato() {
		return IdCampeonato;
	}

	public void setIdCampeonato(int idCampeonato) {
		IdCampeonato = idCampeonato;
	}

	
	//Boolean si esta vacia la lista de Partidos::::
	public boolean isEmpty() {
		
				if(this.partidos.isEmpty())
				return true;
				else
					return false;
	}
	
	
	//Add partido en Lista partidos::::
	public void add(Partido partido) {
		partidos.add(partido);
	}
	
	//Comprueba si ya jugaron los mismos equipos en otro partido recorriendo todos los partidos de todas las Fechas:::
	public boolean yaJugaron(Equipo local, Equipo visitante) {
		
		for(Partido partido: partidos) {
			
			if(partido.partidoExistente(local, visitante));
			
			return true;
		}		
			return false;	
	}
	
	
	
	
}
