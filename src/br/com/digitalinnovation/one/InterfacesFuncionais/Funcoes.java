package br.com.digitalinnovation.one.InterfacesFuncionais;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {

        Function<String, String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        System.out.println(retornarNomeAoContrario.apply("Joao"));

        Function<String, Integer> converterStringParaInteiroEDobra = string -> Integer.valueOf(string) * 2;
        System.out.println(converterStringParaInteiroEDobra.apply("20"));

    }
}
