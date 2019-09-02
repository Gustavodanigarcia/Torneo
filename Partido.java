package ProyectoTorneo.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partido {

	private int id;
	private int fechaCampeonato; //Id Fecha class
	private Equipo local;
	private int golesLocal;
	private int golesVisitante;
	private boolean empate;
	private Equipo visitante;	
	private Equipo ganador;
	
	private List<String> resultado = new ArrayList<>();
	
	
	
	
	
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

	
	
	public Partido(){
		id = (int) (Math.random() * 50); 
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
