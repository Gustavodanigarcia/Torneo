
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class Torneo {

	
	private  List <Equipo> listaEquipos = new ArrayList<Equipo>(); 			
	private  List<Fecha> fechas = new ArrayList<Fecha>(); 					
	private  Fecha fechaNueva = new Fecha();
	private  int cantidadEquipos;                                                             				 		
	private int cantidadFechas;																		
	private int año;																							
	       


	public static void main(String[] args) {

		System.out.println("*****Torneo de Futbol*****");
		
		Torneo Torneo2019 = new Torneo(2019);
		
		Torneo2019.ingresoEquipos(); 

		Torneo2019.mostrarEquipos(); 
		
		Torneo2019.crearFecha(1);
		
		Torneo2019.mostrarCronograma();
	
	}
	
	
	
	
	//Constructores:::
	public Torneo( int año) {  
		this.año = año;
	}

	
	public  void ingresoEquipos() { //Ingresa los equipos y los agrega a la lista de Equipos::: 
		
		Scanner myObj = new Scanner(System.in);    
		int idEquipo;
		int cantidadEquipos;
		String nombreEquipo;

		System.out.println("ingrese la cantidad de equipos que participaran: ");

			cantidadEquipos = Integer.parseInt(myObj.nextLine()); // Validar que sea numero PAR
		while (cantidadEquipos % 2 != 0) {
			System.out.println("el Torneo debe contar con cantidad de equipos PAR: ");
			cantidadEquipos = Integer.parseInt(myObj.nextLine());
		}
		
			this.cantidadEquipos = cantidadEquipos;
		
			for (int i = 0; i < cantidadEquipos; i++) {

			idEquipo = (int) (Math.random() * 500);

			System.out.println("ingrese nombre del Equipo " + (i + 1));

			nombreEquipo = myObj.nextLine();

			Equipo equipoIngresante  = new Equipo(idEquipo, nombreEquipo);

			this.listaEquipos.add(equipoIngresante);
	    
	    }
   
		myObj.close();
			
	}
	
	

public  void mostrarEquipos( ) {  //Muestra los Equipos::: 
		
		System.out.println("\nCantidad de Equipos: " + cantidadEquipos);
		System.out.println("los nombres de los equipos son: ");

		for (Equipo e : listaEquipos) {
			System.out.println("Equipo: " + e.getNombre());
			System.out.println("ID:  " + e.getId());
		}
	
	}


	public int getCantidadEquipos() {
	return cantidadEquipos;
	}


public  void crearFecha (int numFecha) { 
	
	 List<Equipo> EquiposTemporal = this.listaEquipos;
	
	Fecha fechaTemporal = new Fecha();
	 boolean equiposIguales = true;
	 boolean yaJugo = false;
	 boolean  PartidoRepetidoEnTorneo  = false;
	 boolean fechaVacia = true;


	 
    
		 
  
     for(Equipo equipoVisitante: listaEquipos) {
    	 Partido partidoNuevo  = new Partido();
    	 
    	 			yaJugo = fechaTemporal.yaJugo(equipoVisitante);
		    	 	if(yaJugo == true)
		    		 break;


    	 for(Equipo equipoLocal: listaEquipos) {
    		
    	 equiposIguales = equipoVisitante.getNombre().equalsIgnoreCase(equipoLocal.getNombre());
    	 fechaVacia = fechaTemporal.isEmpty();
    	
    	 if(!equiposIguales) {
    		
    		 if(fechaVacia) {
    			partidoNuevo.crear(equipoLocal, equipoVisitante, numFecha+1);
    			fechaTemporal.add(partidoNuevo);
    			break;
   				
    		 }
    		 
    		 PartidoRepetidoEnTorneo = fechas.stream()
						.map((fecha )-> fecha.getPartidos()	)
						.flatMap((partidos) -> partidos.stream())
						.anyMatch((partido) -> partido.partidoExistente(equipoLocal, equipoVisitante));
    	
    	 	}
    	 
    		
    	 	if(!PartidoRepetidoEnTorneo && !fechaVacia) {
    	 		partidoNuevo.crear(equipoLocal, equipoVisitante, numFecha);
    	 		fechaTemporal.add(partidoNuevo);
    	 		break;
    	 	}
    	 
    		 
    	 }
     }
     this.fechas.add(fechaTemporal);																							}  //Fin Funcion



public void mostrarCronograma() {
	

					fechas.stream()
				.map((fecha )-> fecha.getPartidos()	)
				.flatMap((partidos) -> partidos.stream())
				.forEach((partido) -> System.out.println(partido.getVisitante().getNombre() +"  " + partido.getLocal().getNombre()));
					
				Long items	= fechas.stream()
					.map((fecha )-> fecha.getPartidos()	)
					.flatMap((partidos) -> partidos.stream())
					.count();
					System.out.println(items);
				
}



	public void resultados(List<Equipo> lista) {

		int mayor = 0;
		Equipo equipo = null;
		boolean existePuntero = true;
		for (int i = 0; i < lista.size(); i++) {

			if (lista.get(i).getPuntos() > mayor) {
				mayor = lista.get(i).getPuntos();
				equipo = lista.get(i);

}
}

		for (Equipo e : lista) {

			if (e.getPuntos() == equipo.getPuntos() && e.getNombre() != equipo.getNombre()) {
				System.out.println("\n ____________________________________________________________________________");
				System.out.println("\nLos Equipos que mas puntos sacaron fueron: " + e.getNombre() + " con: "
						+ e.getPuntos() + " y " + equipo.getNombre() + " con " + equipo.getPuntos());
				System.out.println("\n ____________________________________________________________________________");
				existePuntero = false;

}
}

		if (existePuntero) {
			System.out.println("\n ____________________________________________________________________________");
			System.out.println("Equipo que mas puntos saco es: " + equipo.getNombre() + " con: " + equipo.getPuntos()
					+ " puntos!");
			System.out.println("\n ____________________________________________________________________________");
}
}

	
public List<Fecha> getFechas() {
	return fechas;
}


public void setFechas(List<Fecha> fechas) {
	this.fechas = fechas;
}









public void Iteraciones() {
	
	Iterator<Equipo> iterador = listaEquipos.iterator();
	while(iterador.hasNext()) {
		
	
		
	}
}


























}//Fin Clase
