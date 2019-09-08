
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partido {

	private int id;
	private int fechaCampeonato; 
	private Equipo local;
	private int golesLocal;
	private int golesVisitante;
	private boolean empate;
	private Equipo visitante;	
	private Equipo ganador;


	private List<String> resultado = new ArrayList<>();
	

	
	
	//Constructor con id random :::::::::
	public Partido(){ 
		id = (int) (Math.random() * 50); 
		
	}	

	
	//Metodos:::::::::::::::::::::::::
	
	//Crear Partido  con local y visitante en la fecha-> FechaCampeonato :::
	public void crear(Equipo local, Equipo visitante, int fechaCampeonato) {
		
		this.local = local;
		this.visitante = visitante;
		this.fechaCampeonato = fechaCampeonato;
	}
	
	
	//Comprueba si los equipos local o visitante estan presente en X partido:::
	public boolean partidoExistente(Equipo local, Equipo visitante ) {
		if((this.local.equals(local) && this.visitante.equals(visitante) || (this.local.equals(visitante) || this.visitante.equals(local))))
		return true;
		else
			return false;
	}
	

	//Jugar Partido::: Setea los goles del Equipo local y visitante y con esas variables define ganador perdedor empate:::
public  void jugar( ) {
	
	Random random = new Random();
	this.golesLocal = random.nextInt(6);
	this.golesVisitante = random.nextInt(6);
	
	this.empate = golesLocal == golesVisitante ? true:false;
	
	if(!this.empate) {
		
		this.ganador = golesLocal > golesVisitante ? this.local:this.visitante;
		this.ganador.setPuntos(ganador.getPuntos() + 3);
											}

	}
	
//Muestra el resultado del partido en Consola::::::
public void mostrarResultado() {
	
	String resultado = null;
	int DiferenciaDeGol = 0;
	
	String equipoLocal = getLocal().getNombre();
	String equipoVisitante = getVisitante().getNombre();
	int Numfecha = getFechaCampeonato();
	
	
	int golesLocal = getGolesLocal();
	int golesVisitante = getGolesVisitante();

	if(!isEmpate())	{ 
		String equipoGanador = getGanador().getNombre();
		
DiferenciaDeGol = Math.abs(getGolesLocal() - getGolesVisitante());

resultado = 			"-En la fecha Nº " +  Numfecha + "\n" 		
										+ "\n" +  equipoLocal + ":" + golesLocal + "  VS  "  + equipoVisitante + ":" + golesVisitante
										+ "\n el ganador fue: " + equipoGanador + " con una diferencia de goles de: " + DiferenciaDeGol 
										+ "\n  ";
						
	}else {
	
	
resultado = 			"-Empate la fecha Nº " +  Numfecha+ "\n" 
										 + " jugaron:  " + equipoLocal + " y el visitante: " + equipoVisitante			
								 		+ "\n el equipo local anoto: " + golesLocal + " y el visitante: " +  golesVisitante
										 + " por lo tanto fue un empate " + " no se sacaron diferencia de gol"
										 + "\n  ";
	}
	

	System.out.println(resultado);
	System.out.println(" -    -    -     -    -     -    -     -    -    -    -     -     -    -    -");
}

	
	
	
	
	
	
	


//Getters y Setters::::::::::::::::::

public boolean isEmpate() {
	return empate;
}
public void setEmpate(boolean empate) {
	this.empate = empate;
}
public int getGolesLocal() {
	return golesLocal;
}
public void setGolesLocal(int golesLocal) {
	this.golesLocal = golesLocal;
}
public int getGolesVisitante() {
	return golesVisitante;
}
public void setGolesVisitante(int golesVisitante) {
	this.golesVisitante = golesVisitante;
}
public Equipo getGanador() {
	return ganador;
}
public void setGanador(Equipo ganador) {
	this.ganador = ganador;
}
public List<String> getResultado() {
	return resultado;
}	
public void setResultado(List<String> resultado) {
	this.resultado = resultado;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getFechaCampeonato() {
	return fechaCampeonato;
}
public void setFechaCampeonato(int fechaCampeonato) {
	this.fechaCampeonato = fechaCampeonato;
}
public Equipo getLocal() {
	return local;
}
public void setLocal(Equipo local) {
	this.local = local;
}
public Equipo getVisitante() {
	return visitante;
}
public void setVisitante(Equipo visitante) {
	this.visitante = visitante;
}
	
}
