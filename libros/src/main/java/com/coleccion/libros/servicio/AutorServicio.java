package com.coleccion.libros.servicio;

import com.coleccion.libros.entidad.Autor;
import com.coleccion.libros.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    public List<Autor> listarTodosLosAutores() {
        return autorRepositorio.findAll();
    }

    public List<Autor> listarAutoresVivosEnAno(int ano) {
        return autorRepositorio.findByAnoNacimientoBeforeAndAnoFallecimientoAfter(ano);
    }
}
