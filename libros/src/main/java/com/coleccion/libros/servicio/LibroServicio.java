package com.coleccion.libros.servicio;

import com.coleccion.libros.entidad.Libro;
import com.coleccion.libros.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> libros = libroRepositorio.findAll();
        return libros.stream()
                .filter(libro -> {
                    String tituloLibro = libro.getTitulo().toUpperCase();
                    return tituloLibro.contains(titulo) || similaridad(tituloLibro, titulo) >= 0.5;
                })
                .collect(Collectors.toList());
    }

    private double similaridad(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int maxLength = Math.max(str1.length(), str2.length());
        int distancia = distanciaLevenshtein(str1, str2);
        return (maxLength - distancia) / (double) maxLength;
    }

    private int distanciaLevenshtein(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1]
                                    + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1,
                                    dp[i][j - 1] + 1));
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
