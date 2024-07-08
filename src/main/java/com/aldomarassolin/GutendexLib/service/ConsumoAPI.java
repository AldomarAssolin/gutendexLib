package com.aldomarassolin.GutendexLib.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            System.out.println("Chamando URL: " + endereco); // Log da URL sendo chamada
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API: " + response.body()); // Log da resposta da API
            System.out.println("Endereço: " + endereco);
            System.out.println("Response: " + response);
        } catch (IOException e) {
            System.err.println("Erro de IO: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.err.println("Erro de Interrupção: " + e.getMessage());
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
