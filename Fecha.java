package ProyectoTorneo.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Fecha {

	
	private int numeroDeFecha;
	private int a�o;
	private List<Partido> partidos = new ArrayList<>();
	
	public Fecha() {
		
		
		
		
		
	}
	
	
	
	public List<Partido> getPartidos() {
		return partidos;
	}



	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}



	public int getNumeroDeFecha() {
		return numeroDeFecha;
	}
	public void setNumeroDeFecha(int numeroDeFecha) {
		this.numeroDeFecha = numeroDeFecha;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	
}
