package com.coleccion.libros.repositorio;

import com.coleccion.libros.entidad.Autor;
import com.coleccion.libros.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma);
    List<Libro> findByTituloContaining(String titulo);
}

