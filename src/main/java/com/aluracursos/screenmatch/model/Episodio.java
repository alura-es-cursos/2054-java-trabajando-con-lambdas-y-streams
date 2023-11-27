package com.aluracursos.screenmatch.model;



import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private Integer temporada;
    private  String titutlo;
    private Integer numeroEpisodio;
    private Double evaluacion;
    private LocalDate fechaDeLanzamiento;

    public Episodio(Integer temporada, DatosEpisodio datosEpisodio) {
        this.temporada = temporada;
        this.titutlo = datosEpisodio.titutlo();
        this.numeroEpisodio = datosEpisodio.numeroEpisodio();
        try {
            this.evaluacion = Double.valueOf(datosEpisodio.evaluacion()) ;
        } catch (NumberFormatException ex){
            this.evaluacion = 0.0;
        }
        try{
            this.fechaDeLanzamiento = LocalDate.parse(datosEpisodio.fechaDeLanzamiento());
        }catch (DateTimeParseException ex){
            this.fechaDeLanzamiento = null;
        }

    }

    @Override
    public String toString() {
        return
                "temporada=" + temporada +
                ", titutlo='" + titutlo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", evaluacion=" + evaluacion +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitutlo() {
        return titutlo;
    }

    public void setTitutlo(String titutlo) {
        this.titutlo = titutlo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
}
