package com.coleccion.libros.consumo;

import com.coleccion.libros.modelo.Libros;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        ConsumoApi api = new ConsumoApi();
        try {
            List<Libros> libros = api.obtenerLibros();
            for (Libros libro : libros) {
                System.out.println("Título: " + libro.titulo);
                System.out.println("Autores: " + libro.autores);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
