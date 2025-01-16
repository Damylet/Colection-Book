package com.coleccion.libros.consumo;

import com.coleccion.libros.modelo.Libros;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConsumoApi {

    private static final String API_URL = "<https://gutendex.com/books/?page=2>";

    public List<Libros> obtenerLibros() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        RespuestaApi respuestaApi = mapper.readValue(respuesta.body(), RespuestaApi.class);

        return respuestaApi.resultados;
    }

    public static class RespuestaApi {
        public int cantidad;
        public String siguiente;
        public String anterior;
        public List<Libros> resultados;
    }
}
