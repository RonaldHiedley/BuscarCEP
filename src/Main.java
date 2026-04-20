import br.com.BuscarCEP.modelos.Cep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String busca = "";
        List<Cep> ceps = new ArrayList<>();

        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();


        while (!busca.equalsIgnoreCase("Sair")) {

            System.out.println("Digite seu CEP:");
            busca = input.nextLine();

            if(busca.equalsIgnoreCase("Sair")) {
                break;
            }

            try{
                String endereco = "https://viacep.com.br/ws/" + busca + "/json/";

                HttpClient client = HttpClient.newHttpClient();//cliente HTTP
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))//define endereco
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());// corpo da resposta em String

                String json =response.body();
                System.out.println(json);

                Cep meusCeps =  gson.fromJson(json, Cep.class);
                ceps.add(meusCeps);

            }
             catch(Exception e) {
                 System.out.println("Erro ao tentar buscar CEP");
                 System.out.println(e.getMessage());
             }

            try(FileWriter escrita = new FileWriter("ceps.json")) {
                escrita.write(gson.toJson(ceps));
                System.out.println("Arquivo gravado com sucesso!");
            }catch (IOException e){
                System.out.println("Erro ao salvar arquivo.");
                e.printStackTrace();
            }


        }

        System.out.println(ceps);

//        FileWriter escrita = new FileWriter("ceps.json");
//        escrita.write(gson.toJson(ceps));
//        escrita.close();
    }
}