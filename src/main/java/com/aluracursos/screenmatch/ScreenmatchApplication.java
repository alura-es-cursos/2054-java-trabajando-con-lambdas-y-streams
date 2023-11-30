package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.pruebas.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Principal principal = new Principal();
//		principal.muestraElMenu();
//		var buscarEpisodios = new BuscarEpisodios();
//		buscarEpisodios.buscarEpisodios();
//		var ejemploStreams = new EjemploStreams();
//		ejemploStreams.muestraListaDeInstructores();
//		var topEpisodios = new TopEpisodios();
//		topEpisodios.muestraTopEpisodios();
//		var buscarEpisodio = new BuscarEpisodiosPorParametros();
//		buscarEpisodio.buscarEpisodiosPorParametro();
		var estadisticas = new TrabajarEstadisticas();
		estadisticas.mostrarEstadisticas();




	}
}
