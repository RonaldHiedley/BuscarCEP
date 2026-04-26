package br.com.BuscarCEP.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaCep(String cep) {

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();//cliente HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)//define endereco
                .build();
        HttpResponse<String> response = null;// corpo da resposta em String
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }


        return new Gson().fromJson(response.body(), Endereco.class);

    }

}
