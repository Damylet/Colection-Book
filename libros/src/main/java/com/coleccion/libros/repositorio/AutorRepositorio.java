package com.coleccion.libros.repositorio;


import com.coleccion.libros.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    List<Autor> findByAnoNacimientoBeforeAndAnoFallecimientoAfter(int ano);
}
