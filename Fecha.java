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
		this.IdFecha = idFecha;
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
		this.IdCampeonato = idCampeonato;
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
		this.IdFecha = partido.getFechaCampeonato();
	}
	
	//Comprueba si ya jugaron los mismos equipos en otro partido recorriendo todos los partidos de todas las Fechas:::
	public boolean yaJugaron(Equipo local, Equipo visitante) {
		
		boolean abc = partidos.stream().anyMatch(p -> p.partidoExistente(local, visitante));	
		
		for(Partido partido: partidos) {
			
			if(partido.partidoExistente(local, visitante));
			
			return true;
		}		
			return false;	
	}
	
	
	public boolean equiposRepetidos(Equipo local, Equipo visitante) {
		for(Partido partido: partidos) {
			if(partido.getLocal().equals(local) || partido.getLocal().equals(visitante) || partido.getVisitante().equals(local) || partido.getVisitante().equals(visitante))
			return true;
		}		
		return false;
	}
	
	
	public void mostrarResultado() {
		
		String resultado = null;
		String fecha = null;
		int DiferenciaDeGol = 0;
		int i= 0;
		for(Partido partido: partidos) {
		
		String equipoLocal = partido.getLocal().getNombre();
		String equipoVisitante = partido.getVisitante().getNombre();
		int Numfecha = partido.getFechaCampeonato();
		fecha = "\n--------------En la fecha Nº " +  Numfecha + " ------------------\n" ;
		
		int golesLocal = partido.getGolesLocal();
		int golesVisitante = partido.getGolesVisitante();

		if(!partido.isEmpate())	{ 
			String equipoGanador = partido.getGanador().getNombre();
			
	DiferenciaDeGol = Math.abs(partido.getGolesLocal() - partido.getGolesVisitante());

	
	
	
	resultado = 			"\n • " +  equipoLocal + ":" + golesLocal + "  VS  "  + equipoVisitante + ":" + golesVisitante
											+ "\n el ganador fue: " + equipoGanador + ", con una diferencia de goles de: " + DiferenciaDeGol 
											+ "\n ";
							
		}else {
		
		
	resultado = 			 "\n • " +  equipoLocal + ":" + golesLocal + "  VS  "  + equipoVisitante + ":" + golesVisitante		
											 + "\n Empate, no se sacaron diferencia de gol"
											 + "\n ";
		}
		
		if(i == 0)
			System.out.println(fecha);
		System.out.println(resultado);

		i++;
	}

	
	
	
	}
	
}
