import br.com.BuscarCEP.modelos.Endereco;
import br.com.BuscarCEP.modelos.ConsultaCep;
import br.com.BuscarCEP.modelos.GeradorDeArquivo;
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
        ConsultaCep consultaCep = new ConsultaCep();
        System.out.println("Digite o CEP:");
        var cep = input.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaCep(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println("Finalizando aplicação");
        }


//        Scanner input = new Scanner(System.in);
//        String busca = "";
//        List<Cep> ceps = new ArrayList<>();
//
//        Gson gson = new GsonBuilder()
////                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//                .setPrettyPrinting()
//                .create();
//
//
//        while (!busca.equalsIgnoreCase("Sair")) {
//
//            System.out.println("Digite seu CEP:");
//            busca = input.nextLine();
//
//            if(busca.equalsIgnoreCase("Sair")) {
//                break;
//            }
//
////            try{
//////                String endereco = "https://viacep.com.br/ws/" + busca + "/json/";
////
////
//////                System.out.println(json);
////
////                Cep meusCeps =  gson.fromJson(json, Cep.class);
////                ceps.add(meusCeps);
////
////            }
////             catch(Exception e) {
////                 System.out.println("Erro ao tentar buscar CEP");
////                 System.out.println(e.getMessage());
////             }
////
////            try(FileWriter escrita = new FileWriter("ceps.json")) {
////                escrita.write(gson.toJson(ceps));
////                System.out.println("Arquivo gravado com sucesso!");
////            }catch (IOException e){
////                System.out.println("Erro ao salvar arquivo.");
////                e.printStackTrace();
////            }
//
//
//        }
//
//        System.out.println(ceps);
//
////        FileWriter escrita = new FileWriter("ceps.json");
////        escrita.write(gson.toJson(ceps));
////        escrita.close();
    }
}