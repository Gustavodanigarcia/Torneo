import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class Torneo {

	
	private  List <Equipo> listaEquipos = new ArrayList<Equipo>(); 			
	private  List<Fecha> fechas = new ArrayList<Fecha>(); 					
	
	private  int cantidadEquipos;                                                             				 																		
	private int año;																							
	       


	public static void main(String[] args) {
		System.out.println("**********************************************************************************");
		System.out.println("                            Torneo de Futbol");
		System.out.println("**********************************************************************************");
		
		
		Torneo Torneo2019 = new Torneo(2019);

	
		Torneo2019.ingresoEquipos(); 
			
		Torneo2019.crearFecha(1);
	
		Torneo2019.crearFecha(2);
		
		Torneo2019.crearFecha(3);
		
		Torneo2019.crearFecha(4);
		
		Torneo2019.crearFecha(5);
		
		Torneo2019.crearFecha(6);
		
		Torneo2019.crearFecha(7);
		
		Torneo2019.crearFecha(8);
		
		Torneo2019.jugarPartidos();
		
		Torneo2019.mostrarEquipos(); 
		
		Torneo2019.TablaResultados();
		
		Torneo2019.TablaClasificacion();
		
		Torneo2019.puntero();
	

	}
	
	
	
	
	//Constructores:::
	public Torneo( int año) {  
		this.año = año;
	}

	
	public  void ingresoEquipos() { //Ingresa los equipos y los agrega a la lista de Equipos::: 
		
		Scanner myObj = new Scanner(System.in);    
		int idEquipo;
		int cantidadEquipos;
		int min = 1000;
		int max = 2000;
		String nombreEquipo;
		
		System.out.println("\n -ingrese la cantidad de equipos que participaran: ");

			cantidadEquipos = Integer.parseInt(myObj.nextLine()); // Validar que sea numero PAR
		while (cantidadEquipos % 2 != 0) {
			System.out.println("el Torneo debe contar con cantidad de equipos PAR!!!:");
			cantidadEquipos = Integer.parseInt(myObj.nextLine());
		}
		
			this.cantidadEquipos = cantidadEquipos;
		
			for (int i = 0; i < cantidadEquipos; i++) {

			//idEquipo = (int) (Math.random() * (600 - 100) + 600);
			 idEquipo = ThreadLocalRandom.current().nextInt(min, max + 1);
			System.out.println(" -ingrese nombre del Equipo " + (i + 1));

			nombreEquipo = myObj.nextLine();

			Equipo equipoIngresante  = new Equipo(idEquipo, nombreEquipo);

			this.listaEquipos.add(equipoIngresante);
	    
	    }
   
		myObj.close();
			
	}
	
	

public  void TablaResultados() {  //Muestra los Equipos::: 

	System.out.println("\n********************************************");
	System.out.println("                  RESULTADOS "    );
	System.out.println("********************************************");
	
	String fechaTable = "|                  %-15s          |%n";
	String	resultadosTable = "| %-15s | %-4s | %-16s |%n";

	
	fechas.stream().forEach((fecha) -> {
		
		if(!fecha.isEmpty()) {
	System.out.format("\n\n+-------------------------------------------+%n");
	System.out.format(fechaTable, "FECHA " + fecha.getIdCampeonato());

	
	
	System.out.format("+-------------------------------------------+%n");
	System.out.format("| Equipo Local    |  R   | Equipo Visitante |%n");
	System.out.format("+-----------------+------+------------------+%n");
	fecha.getPartidos().forEach((partido)-> {
		
		System.out.format(resultadosTable, partido.getLocal().getNombre(), partido.getGolesLocal() + "-" + partido.getGolesVisitante(), partido.getVisitante().getNombre());
	});
	System.out.format("+-----------------+------+------------------+%n");
		}});
	
}



public  void mostrarEquipos( ) {  //Muestra los Equipos::: 
	List <Equipo> ordenada = listaEquipos.stream().sorted(Comparator.comparing(Equipo::getId)).collect(Collectors.toList());
	
	System.out.println("\n**********************************************");
	System.out.println("                   EQUIPOS" );
	System.out.println("**********************************************\n");
	
	String tablaEquiposFormat = "| %-15s | %-4d |%n";

	
	
	System.out.format("+-----------------+------+%n");
	System.out.format("| Equipo          |  ID  |%n");
	System.out.format("+-----------------+------+%n");
	ordenada.forEach((equipo) -> {
		
		System.out.format(tablaEquiposFormat, equipo.getNombre(), equipo.getId());

});
	System.out.format("+-----------------+------+%n");
}




	public int getCantidadEquipos() {
	return cantidadEquipos;
	}


	public  void crearFecha (int numFecha) { 
	


	 
	 boolean equiposIguales = true;
	 boolean equiposYajugaronEnLaFecha = true;
	 boolean  PartidoRepetidoEnTorneo  = true;
	 boolean fechaVacia = true;

	 
     Fecha fechaNueva = new Fecha();
     fechaNueva.setIdCampeonato(numFecha);

     
     				for(Equipo equipoVisitante: listaEquipos) { 				 //Recorre lista Equipos y comprobar si se puede agregar como Visitante							
								
					for(Equipo equipoLocal: listaEquipos) {   					 //Recorre lista Equipos y comprobar si se puede agregar como Local					
						
						
						 Partido partidoNuevo  = new Partido();
						equiposIguales = equipoVisitante.equals(equipoLocal);
						fechaVacia = fechaNueva.isEmpty(); //Si fecha vacia agrega los equipos a un nuevo partido
										
						
					if(!equiposIguales) {  //Equipos distintos Entra al IF
	
								if(fechaVacia && fechaNueva.getIdCampeonato() == 1) {
								partidoNuevo.crear(equipoLocal, equipoVisitante, numFecha);
								fechaNueva.add(partidoNuevo);
																																										}
								
								equiposYajugaronEnLaFecha = fechaNueva.equiposRepetidos(equipoLocal, equipoVisitante);
								
								if(!equiposYajugaronEnLaFecha) {

						
					
									PartidoRepetidoEnTorneo = fechas.stream()
															   .map((fecha )-> fecha.getPartidos())
															   .flatMap((partidos) -> partidos.stream())
															   .anyMatch((partido) -> partido.partidoExistente(equipoLocal, equipoVisitante));
			
					
							
						 		//SI el partido No esta repetido en todo el torneo -->
								if(!PartidoRepetidoEnTorneo) {
							
								partidoNuevo.crear(equipoLocal, equipoVisitante, numFecha);							
								fechaNueva.add(partidoNuevo);	
								
								
								
																									} //Fin IF Partido ya se jugo en Todo el torneo almenos alguna vez 
																									}  //Fin IF Equipo L o V ya jugaron en la fecha		
																									}  //Fin IF Equipos Iguales
																									}  //Fin FOR: Equipo Local																									
																									}	//Fin FOR: Equipo Visitante 				
     							this.fechas.add(fechaNueva);
																									}  //Fin Funcion





public void jugarPartidos() {

	for(Fecha f: this.fechas) {

		for(Partido p: f.getPartidos()) {
			
			p.jugar();
	
}
}
}



	
	public  void puntero() {
		int j = 0;
		int mayor = 0;
		Equipo equipo = null;
		boolean existePuntero = true;
		
		for (int i = 0; i < listaEquipos.size(); i++) {

			if (listaEquipos.get(i).getPuntos() > mayor) {
				mayor = listaEquipos.get(i).getPuntos();
				equipo = listaEquipos.get(i);
				
}
}

		for (Equipo e : listaEquipos) {

			if (e.getPuntos() == equipo.getPuntos() && e.getNombre() != equipo.getNombre() && j<1) {
				System.out.println("\n ____________________________________________________________________________________________________");
				System.out.println("\nLos 2 Equipos que mas puntos sacaron fueron: " + e.getNombre() + " con: "
						+ e.getPuntos() + " y " + equipo.getNombre() + " con " + equipo.getPuntos());
				System.out.println("\n ____________________________________________________________________________________________________");

				j++;
				existePuntero = false;

}
}

		if (existePuntero) {
			System.out.println("\n ____________________________________________________________________________________________________");
			System.out.println("\nEl Campeon del Torneo es: " + equipo.getNombre() + " con: " + equipo.getPuntos()
					+ " puntos!");
			System.out.println("\n ____________________________________________________________________________________________________");

}
}

	
	
	
	
	public  void TablaClasificacion() {  //Muestra los Equipos::: 
		List <Equipo> ordenada = listaEquipos.stream().sorted(Comparator.comparing(Equipo::getPuntos).reversed()).collect(Collectors.toList());
		
		System.out.println("\n********************************************");
		System.out.println("               RANKING GENERAL   "       );
		System.out.println("********************************************");
		
		String fechaTable = "|                  %-15s          |%n";
		String	clasificacionTabla = "| %-15s| %-2s| %-2s| %-2s|    %-3s   |%n";

		System.out.format("+---------------------------------------+%n");
		System.out.format("| Equipo         | G | E | P |  Puntos  |%n");
		System.out.format("+---------------------------------------+%n");

		
		ordenada.forEach((equipo) -> {
			
			System.out.format(clasificacionTabla, equipo.getNombre(), equipo.getPartidosGanados(), equipo.getPartidosEmpatados(), equipo.getPartidosPerdidos(), equipo.getPuntos());
	
	});
		System.out.format("+---------------------------------------+%n");
		}
		
	

	
	
	
	
	
	
	
	
	
	
	
	
public List<Fecha> getFechas() {
	return fechas;
}


public void setFechas(List<Fecha> fechas) {
	this.fechas = fechas;
}






public String getNombre(int id) {
	return listaEquipos.get(id).getNombre();
}

public int getId(int id) {
	return listaEquipos.get(id).getId();
}

public void Iteraciones() {
	
	Iterator<Equipo> iterador = listaEquipos.iterator();
	while(iterador.hasNext()) {
		
	
		
	}
}


}//Fin Clase
