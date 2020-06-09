package br.com.digitalinnovation.one.InterfacesFuncionais;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {


        Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Hello World");


        //Method Reference
        Consumer<String> imprimirUmaFraseMethodReference = System.out::println;
        imprimirUmaFraseMethodReference.accept("Hello World Method Reference");
    }
}
