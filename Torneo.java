
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;






public class Torneo {

	

	
	private static List <Equipo> listaEquipo = new ArrayList<Equipo>();
	
	private static List <Partido> fecha = new ArrayList<Partido>();
	private static List <Partido> fecha2 = new ArrayList<Partido>();
	private static List <Partido> fecha3 = new ArrayList<Partido>();
	private static List <Partido> fechaPrueba = new ArrayList<Partido>();
	private static List<List<Partido>> Torneo = new ArrayList<List<Partido>>();
	
	
	private static int cantidadEquipos;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myObj = new Scanner(System.in);
		System.out.println("*****Torneo de Futbol*****");

		ingresoEquipos(myObj, listaEquipo); // --> usuario ingresa los equipos

		mostrarEquipos(listaEquipo); // --> muestra los equipos
	}
		
//
//		System.out.println("*********************************");
//		System.out.println("PRIMERA FECHA:");
//		System.out.println("*********************************");
//
//		fecha = crearFecha(listaEquipo, 1);
//
//		for (Partido p : fecha) {
//
//			mostrarResultado(p);
//
//		}

//		fechas.add(fecha); // Se agrega a la lista fecha que es una lista de partidos:::
//
//		fecha2 = crearFecha(listaEquipo, 2);
//
//		System.out.println("*********************************");
//		System.out.println("SEGUNDA FECHA:");
//		System.out.println("*********************************");
//		for (Partido p : fecha2) {
//
//			mostrarResultado(p);
//
//		}
//
//		fechas.add(fecha2);
//
//		fecha3 = crearFecha(listaEquipo, 3);
//
//		System.out.println("*********************************");
//		System.out.println("TERCERA FECHA:");
//		System.out.println("*********************************");
//		for (Partido p : fecha3) {
//
//			mostrarResultado(p);
//
//		}
//
//		resultados(listaEquipo);
//
//		fechas.add(fecha3);
//
//	}


	public static void ingresoEquipos(Scanner myObj, List <Equipo> listaEquipo) { //Ingresa los equipos y los agrega a la lista de Equipos::: 
		
		int idEquipo;
		String nombreEquipo;

		System.out.println("ingrese la cantidad de equipos que participaran: ");

		cantidadEquipos = Integer.parseInt(myObj.nextLine()); // Validar que sea numero del 2 al 20
		while (cantidadEquipos % 2 != 0) {
			System.out.println("el Torneo debe contar con cantidad de equipos PAR: ");
			cantidadEquipos = Integer.parseInt(myObj.nextLine());
		}

		for (int i = 0; i < cantidadEquipos; i++) {

			idEquipo = (int) (Math.random() * 500);

			System.out.println("ingrese nombre del Equipo " + (i + 1));

			nombreEquipo = myObj.nextLine();

			Equipo ingreso = new Equipo();

			ingreso.setId(idEquipo);

			ingreso.setNombre(nombreEquipo);

			listaEquipo.add(ingreso);
	    
	    }
   
		
	}

public static void mostrarEquipos( List<Equipo> lista) {  //Muestra los Equipos::: 

		int cantidadDeEquipos = lista.size();

		System.out.println("\nCantidad de Equipos: " + cantidadDeEquipos);
		System.out.println("los nombres de los equipos son: ");

		for (Equipo e : lista) {
			System.out.println("Equipo: " + e.getNombre());
			System.out.println("ID:  " + e.getId());
		}
	
	}

	

public static List<List<Partido>>  crearTorneo (List<Equipo> lista) { 
	
	//String []  equiposTotales 
	
//	Equipo local = new Equipo();
//	Equipo visitante = new Equipo();
	
	int cantidadFechas = lista.size() - 1;
	 fecha = null;		
	 boolean EquipoJugoEnEstaFecha = false;
	 boolean SeJugoPartido = false;
	// List<List<Partido>> fechas = new ArrayList<List<Partido>>(); 		ya Creado en la clase

	
	for(int i=0; i<cantidadFechas; i++) {
	
				for(Equipo equipoVisitante: lista) { 				 //Recorre lista Equipos y comprobar si se puede agregar como Visitante							
									
					for(Equipo equipoLocal: lista) {   					 //Recorre lista Equipos y comprobar si se puede agregar como Local
											
							if(equipoLocal == equipoVisitante)   // en un mismo partido no se puede tener 2 equipos iguales
								break;
							
							Partido partidoDeFutbol = new Partido();
						
							partidoDeFutbol.setFechaCampeonato(i);   //los partidos se separan por fecha campeonato ID = numero de fecha campeonato
							
							if(Torneo.isEmpty() && fecha.isEmpty()) {                                                                //Si el torneo esta vacio, 
								partidoDeFutbol.setLocal(equipoLocal);
								partidoDeFutbol.setVisitante(equipoVisitante);
								fecha.add(partidoDeFutbol);
								
								Torneo.add(fecha);
								break;
							}
							/*
							EquipoJugoEnEsaFecha = obtenerFechaCampeonato(i).stream().filter(partido -> partido.getLocal() == equipoLocal || partido.getLocal() == equipoVisitante )
							*/
									
							EquipoJugoEnEstaFecha = obtenerFechaCampeonato(i).stream().anyMatch(p -> p.getLocal().equals(equipoLocal)  ||  p.getVisitante().equals(equipoLocal));
						
							if(EquipoJugoEnEstaFecha)
							{	break;									
							}
							
							Partido partidoTemporal = new Partido();
							
							//SeJugoPartido = Torneo.stream().filter(id)
		
																							}
					
																							}
	}
				return Torneo;
				
}
	



public static void mostrarResultado(Partido partido) {
	
	String resultado = null;
	int DiferenciaDeGol = 0;
	
	String equipoLocal = partido.getLocal().getNombre();
	String equipoVisitante = partido.getVisitante().getNombre();
	
	String equipoGanador = null; 
	
	
	int golesLocal = partido.getGolesLocal();
	int golesVisitante = partido.getGolesVisitante();

	if(partido.isEmpate() == false)	{ 

		equipoGanador = partido.getGanador().getNombre();

		
	if(partido.getGanador() == partido.getLocal()) {
		DiferenciaDeGol = Math.abs(partido.getGolesLocal() - partido.getGolesVisitante());

}	else {
	DiferenciaDeGol =  Math.abs(partido.getGolesVisitante() - partido.getGolesLocal());
	}
	

	
resultado = 			"-En la fecha Nº " +  partido.getFechaCampeonato() + "\n" 
										+ " jugaron en la cancha de \n "
										+ equipoLocal + " y el visitante: " + equipoVisitante						
										+ "\n el equipo de: " +  equipoLocal + " anoto: " + golesLocal + " y el visitante: " + golesVisitante
										+ "\n entonces el ganador fue: " + equipoGanador + " con una diferencia de goles de: " + DiferenciaDeGol 
										+ "\n  ";
						
	}else {
	
	
	resultado = "-Empate la fecha Nº " +  partido.getFechaCampeonato() + "\n" 
								+ " jugaron:  " + equipoLocal + " y el visitante: " + equipoVisitante			
								 + "\n el equipo local anoto: " + golesLocal + " y el visitante: " +  golesVisitante
								 + " por lo tanto fue un empate " + " no se sacaron diferencia de gol"
								 + "\n  ";
	}
	

	System.out.println(resultado);

}
	
	


	public static void resultados(List<Equipo> lista) {

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

	
	
	
	
	

public static Partido  crearPartido (Equipo Local, Equipo Visitante, int fechaCampeonato) { //Jugar Partido
	
	Equipo local = new Equipo();
	Equipo visitante = new Equipo();
	Equipo equipoGanador = null;
	int golesLocal;
	int golesVisitante;
	boolean esEmpate = true;
	
	Random random = new Random();
	
	
			
		Partido partidoDeFutbol = new Partido();
		
		partidoDeFutbol.setFechaCampeonato(fechaCampeonato);
		
		local = Local;
		visitante = Visitante;
		
		partidoDeFutbol.setLocal(local);
		partidoDeFutbol.setVisitante(visitante);
		
		
		golesLocal = random.nextInt(5);
		golesVisitante = random.nextInt(4);
	

		partidoDeFutbol.setGolesLocal(golesLocal);
		partidoDeFutbol.setGolesVisitante(golesVisitante);
		
		esEmpate = (golesLocal == golesVisitante) ? true:false;		

		
		if(esEmpate == false) {
			partidoDeFutbol.setEmpate(esEmpate);
			
			equipoGanador = golesLocal > golesVisitante ? local:visitante;
			
			equipoGanador.setPuntos(equipoGanador.getPuntos() + 3);
			
			partidoDeFutbol.setGanador(equipoGanador);				
			
		}else if(esEmpate == true) {
			
			partidoDeFutbol.setEmpate(esEmpate);
			
		}
	

	return partidoDeFutbol;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
public Equipo  buscarEquipoPorID(int idEquipo) {
	for (Equipo e: listaEquipo) {
	if(e.getId() == idEquipo)
		return e;
	}
	return null;
}
	

public Partido buscarPartidoPorID(int idPartido) {
		for(Partido p: fecha) {
			
			if(p.getId() == idPartido)
				return p;
		}
		return null;
}






public static List<Partido> obtenerFechaCampeonato(int idFecha) {
			int i= 0;
	for( List<Partido> fecha: Torneo) {
	
		if(fecha.get(i).getFechaCampeonato() == idFecha) {
		
		}
		i++;
			return fecha;
	}
	return null;
}



	
}




/*
for(Equipo equipoVisitante: lista) { //Se crea 1 partido cada 2 Equipos									
	
	for(Equipo equipoLocal: lista) {
		
		if(equipoLocal != equipoVisitante && cantidadPartidos != 0) {							
		
			local = equipoLocal;
			visitante = equipoVisitante;			
			
			
			for(Partido partido: fecha) {
				local.getId() != 
			}
			
			partidoDeFutbol = crearPartido(local,visitante,fechaCampeonato);
			fecha.add(partidoDeFutbol);
			cantidadPartidos--; 
			break;
		}
	}

}

*/
