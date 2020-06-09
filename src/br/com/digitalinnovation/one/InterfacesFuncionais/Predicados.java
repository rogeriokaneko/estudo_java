package br.com.digitalinnovation.one.InterfacesFuncionais;

import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args) {
        //Predicate<String> estaVazia = valor -> valor.isEmpty();
        Predicate<String> estaVazia = String::isEmpty;

        System.out.println(estaVazia.test(""));
        System.out.println(estaVazia.test("Joao"));
    }
}
