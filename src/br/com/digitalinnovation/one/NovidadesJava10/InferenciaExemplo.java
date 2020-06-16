package br.com.digitalinnovation.one.NovidadesJava10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenciaExemplo {

    //var não pode ser utilizado em variável global
    //public var nome = "Joao";

    public static void main(String[] args) throws IOException {
//        URL url = new URL("https://docs.oracle.com/javase/10/language/");
//        URLConnection urlConnection = url.openConnection();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        printarNomeCompleto("Joao", "Santos");
        printarSoma(5, 5, 5);

    }

    private static void connectAndPrintURLJavaOracle() throws IOException {
        var url = new URL("https://docs.oracle.com/javase/10/language/");
        var urlConnection = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        System.out.println(bufferedReader.lines()
            .collect(Collectors.joining())
            .replaceAll(">", ">\n"));
    }


    public static void printarNomeCompleto(String nome, String sobrenome){
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros){
        int soma;
        if(numeros.length > 0){
            soma = 0;
            for(var numero: numeros){
                soma += numero;
            }

            System.out.println("A soma é = " + soma);
        }
    }

    /**********************Consegue***************************/

    //variaveis locais inicializadas
    //variavel suporte do enhanced for
    //variavel suporte do for iterativo
    //variavel try with resource

    /*******************Não Consegue**************************/
    //var nao pode ser utilizado em nivel de classe;
    //var nao pode ser utilizado como parametro
    //var nao pode ser utilizado em variaveis locais nao inicializadas
}


