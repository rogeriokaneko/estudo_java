package br.com.digitalinnovation.one.NovidadesJava11;


import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionExemplo {
    public static void main(String[] args) {
//        Collection<String> nomes = List.of("Joao", "Paulo", "Oliveira", "Santos");
        Collection<String> nomes = Set.of("Joao", "Paulo", "Oliveira", "Santos");

        System.out.println(nomes);
    }
}
