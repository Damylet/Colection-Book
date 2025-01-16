package com.coleccion.libros.controlador;

import com.coleccion.libros.entidad.Autor;
import com.coleccion.libros.entidad.Libro;
import com.coleccion.libros.servicio.LibroServicio;
import com.coleccion.libros.servicio.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class LibroControlador implements CommandLineRunner {

    @Autowired
    private LibroServicio libroServicio;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores vivos en determinado año");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Corrección: cerrar la línea correctamente

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String titulo = scanner.nextLine().toUpperCase();
                    // Convertir a mayúsculas
                    List<Libro> libros = libroServicio.buscarPorTitulo(titulo);
                    if (!libros.isEmpty()) { libros.forEach(libro -> System.out.println(libro)); }
                    else { System.out.println("No se encontraron libros con ese título."); }
                    break;
                case 2:
                    List<Libro> todosLosLibros = libroServicio.listarTodosLosLibros();
                    if (!todosLosLibros.isEmpty()) {
                        todosLosLibros.forEach(libro -> System.out.println(libro));
                    }
                    else { System.out.println("No hay libros en el catálogo."); }
                    break;
                case 3:
                    List<Autor> todosLosAutores = autorServicio.listarTodosLosAutores();
                    if (!todosLosAutores.isEmpty()) {
                        todosLosAutores.forEach(autor -> System.out.println(autor)); }
                    else { System.out.println("No hay autores en el catálogo.");
                    } break;
                    case 4: // Lógica para listar autores vivos en determinado año
                         System.out.println("Ingrese el año:");
                         int ano = scanner.nextInt(); scanner.nextLine();
                         List<Autor> autoresVivos = autorServicio.listarAutoresVivosEnAno(ano);
                         if (!autoresVivos.isEmpty()) {
                             autoresVivos.forEach(autor -> System.out.println(autor)); }
                     else { System.out.println("No hay autores vivos en ese año."); } break;
                case 5:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }

        scanner.close();
    }
}
