package com.coleccion.libros.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libros {
    public int id;
    public String titulo;
    public List<Autor> autores;
    public List<Traductor> traductores;
    public List<String> temas;
    public List<String> estanterias;
    public List<String> idiomas;
    public boolean derechosAutor;
    @JsonProperty("media_type")
    public String tipoMedia;
    public Formatos formatos;
    @JsonProperty("download_count")
    public int cantidadDescargas;

    // Getters y Setters

    public static class Autor {
        public String nombre;
        @JsonProperty("birth_year")
        public int anoNacimiento;
        @JsonProperty("death_year")
        public int anoFallecimiento;

        // Getters y Setters
    }

    public static class Traductor {
        public String nombre;
        @JsonProperty("birth_year")
        public Integer anoNacimiento;
        @JsonProperty("death_year")
        public Integer anoFallecimiento;


    }

    public static class Formatos {
        @JsonProperty("text/html")
        public String html;
        @JsonProperty("application/epub+zip")
        public String epub;
        @JsonProperty("application/x-mobipocket-ebook")
        public String mobi;
        @JsonProperty("text/plain; charset=utf-8")
        public String txt;
        @JsonProperty("application/rdf+xml")
        public String rdf;
        @JsonProperty("image/jpeg")
        public String jpeg;
        @JsonProperty("application/octet-stream")
        public String zip;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Traductor> getTraductores() {
        return traductores;
    }

    public void setTraductores(List<Traductor> traductores) {
        this.traductores = traductores;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public List<String> getEstanterias() {
        return estanterias;
    }

    public void setEstanterias(List<String> estanterias) {
        this.estanterias = estanterias;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public boolean isDerechosAutor() {
        return derechosAutor;
    }

    public void setDerechosAutor(boolean derechosAutor) {
        this.derechosAutor = derechosAutor;
    }

    public String getTipoMedia() {
        return tipoMedia;
    }

    public void setTipoMedia(String tipoMedia) {
        this.tipoMedia = tipoMedia;
    }

    public Formatos getFormatos() {
        return formatos;
    }

    public void setFormatos(Formatos formatos) {
        this.formatos = formatos;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }
}
