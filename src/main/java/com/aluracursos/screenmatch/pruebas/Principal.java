package com.aluracursos.screenmatch.pruebas;
//
//import com.aluracursos.screenmatch.model.DatosEpisodio;
//import com.aluracursos.screenmatch.model.DatosSerie;
//import com.aluracursos.screenmatch.model.DatosTemporada;
//import com.aluracursos.screenmatch.model.Episodio;
//import com.aluracursos.screenmatch.service.ConsumoAPI;
//import com.aluracursos.screenmatch.service.ConvierteDatos;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Principal {
//    private Scanner teclado = new Scanner(System.in);
//    private final String URL = "https://www.omdbapi.com/?t=";
//    private final String APIKEY = "&apikey=4fc7c187";
//    private ConsumoAPI consumoAPI = new ConsumoAPI();
//    private ConvierteDatos conversor = new ConvierteDatos();
//    public void muestraElMenu(){
//        //Buscar datos de la serie
//        System.out.println("Escribe el nombre de la série que deseas buscar");
//        var nombreSerie = teclado.nextLine();
//        var json = consumoAPI.obtenerDatos(URL + nombreSerie.replace(" ", "+") + APIKEY);
//        //https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187
//        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
//        System.out.println(datos);
//
//        //Buscar datos por temporadas
//        List<DatosTemporada> temporadas = new ArrayList<>();
//
//        for (int i = 1; i <= datos.totalTemporadas(); i++) {
//            json = consumoAPI.obtenerDatos(URL + nombreSerie.replace(" ", "+") + "&Season=" + i + APIKEY);
//            DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
//            temporadas.add(datosTemporada);
//        }
//        temporadas.forEach(System.out::println);
//        //FIN VIDEO 2.4
//        //INICIO VIDEO 2.5
//        //Buscar titulos de los episodios
//        for (int i = 0; i < datos.totalTemporadas(); i++) {
//            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporadas.size(); j++) {
//                System.out.println(episodiosTemporadas.get(j).titutlo());
//            }
//        }
//        //Versión simplificada com lambdas
//        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titutlo())));
//        //FIN VIDEO 2.5
//
//        //INICIO VIDEO 3.1
//        //Ejemplo de uso de streams
////        List<String> nombres = Arrays.asList("Genesys","Eric","Maria","Brenda");
////
////        nombres.stream()
////                .sorted()
////                .limit(2)
////                .filter(n -> n.startsWith("E"))
////                .map(n -> n.toUpperCase())
////                .forEach(System.out::println);
//        //FIN VIDEO 3.1
//        //INICIO 3.2
//        //busqueda de datos de los episodios
//        List<DatosEpisodio> datosEpisodios = temporadas
//                .stream()
//                .flatMap(t -> t.episodios().stream())
//                .collect(Collectors.toList());
//
//
//    //VIDEO 4.1 INICIO
//        //Búsqueda de top 10 de los episodios
////        System.out.println("\n Top 10 episodios");
////        datosEpisodios.stream()
////                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
////                .peek(e -> System.out.println("Primer filtro N/A " + e))
////                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
////                .peek(e -> System.out.println("Ordenando los datos " + e))
////                .limit(10)
////                .peek(e -> System.out.println("Limitando a 10 " + e))
////                .map(e -> e.titutlo().toUpperCase())
////                .peek(e -> System.out.println("Mayusculas " + e))
////                .forEach(System.out::println);
//        // VIDEO 4.1 FIN
//
//        //INICIO VIDEO 3.3
//        //Mostrar todos los datos de los episodios
//        System.out.println("Todos los datos episodios con temporadas");
//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()
//                        .map(d -> new Episodio(t.numero(), d)))
//                .collect(Collectors.toList());
//
//        episodios.forEach(System.out::println);
//        //VIDEO 4.2 INICIO
//        //Buscar episodios por parte del titulo
//        System.out.println("Escribe el nombre del episodio que deseas ver");
////        var pedazoTitulo = teclado.nextLine();
////        Optional<Episodio> episodioBuscado = episodios.stream()
////                .filter(e -> e.getTitutlo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
////                .findFirst();
////        if (episodioBuscado.isPresent()){
////            System.out.println("Episodio encontrado");
////            System.out.println("Temporada: " + episodioBuscado.get());
////        } else {
////            System.out.println("Episodio no encontrado");
////        }
//
//
//
//
//
////        //FIN VIDEO 3.3
////        //INICIO VIDEO 3.4
//        //Buscar episodios a partir de una fecha
////        System.out.println("a partir de que año deseas ver los episodios?");
////        var fecha = teclado.nextInt();
////        teclado.nextLine();
////
////        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
////
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////        episodios.stream()
////                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
////                .forEach(e -> System.out.println(
////                        "Temporada: " + e.getTemporada() +
////                                " Episodio: " + e.getTitutlo() +
////                                " Fecha de Lanzamiento: " + e.getFechaDeLanzamiento().format(formatter)
////                ));
//        // FIN VIDEO 3.4
//
//        //INICIO VIDEO 4.3
//        // Muestra evaluaciones de todas las temporadas
//        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
//                .filter(e -> e.getEvaluacion() > 0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada,
//                        Collectors.averagingDouble(Episodio::getEvaluacion)));
//        System.out.println(evaluacionesPorTemporada);
//        //FIN VIDEO 4.3
//
//        //INICIO VIDEO 4.4
//        //Calcular estadísticas de las evaluaciones de los episodios
//        DoubleSummaryStatistics est = episodios.stream()
//                .filter(e -> e.getEvaluacion() > 0)
//                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
//        System.out.println("Media " + est.getAverage());
//        System.out.println("Mejor episódio: " + est.getMax());
//        System.out.println("Peor episódio: " + est.getMin());
//        System.out.println("Cantidad " + est.getCount());
//    }
//}
