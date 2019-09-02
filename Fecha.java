package ProyectoTorneo.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Fecha {

	
	private int numeroDeFecha;
	private int año;
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
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	
}
