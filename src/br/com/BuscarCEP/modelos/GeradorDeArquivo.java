package br.com.BuscarCEP.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

//    public void salvaJson(Endereco endereco) throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
//        endereco.write(gson.toJson(endereco));
//        escrita.close();
//    }

    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter escrita = new FileWriter(endereco.cep() + ".json")) {
            escrita.write(gson.toJson(endereco));
        }
    }


}
