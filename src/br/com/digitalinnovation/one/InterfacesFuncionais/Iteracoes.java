package br.com.digitalinnovation.one.InterfacesFuncionais;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"Joao", "Joao", "Paulo", "Oliveira", "Santos", "Instrutor", "Java"};
        Integer[] numeros = {1,2,3,4,5};
        //System.out.println(nomes);
        //imprimirNomesFiltrados(nomes);
        imprimirTodosNomes(nomes);

        imprimirODobroDeCadaItemDaLista(numeros);

        List<String> listaProfissoes = new ArrayList<>();
        listaProfissoes.add("Desenvolvedor");
        listaProfissoes.add("Testador");
        listaProfissoes.add("Gerente de Projeto");
        listaProfissoes.add("Gerente de Qualidade");

        listaProfissoes.stream()
                .filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);

    }

    public static void imprimirNomesFiltrados(String... nomes){
        String nomesParaImprimir = "";
        for(int i = 0; i < nomes.length; i++){
            if(nomes[i].equals("Joao")){
                nomesParaImprimir += " " + nomes[i];
            }
        }

        System.out.println(nomesParaImprimir);

        String nomesParaImprimirDaStream = Stream.of(nomes)
                .filter(nome -> nome.equals("Joao"))
                .collect(Collectors.joining(" "));

        System.out.println(nomesParaImprimirDaStream);
    }

    public static void imprimirTodosNomes(String... nomes){
        for(String nome: nomes){
            System.out.println(nome);
        }

        System.out.println("***************Pela Stream****************");
        Stream.of(nomes)
                .forEach(System.out::println);
    }

    public static void imprimirODobroDeCadaItemDaLista(Integer... numeros){
        for(Integer numero: numeros){
            System.out.println(numero * 2);
        }

        System.out.println("********************Pela Stream********************");

        Stream.of(numeros)
                .map(numero -> numero * 2)
                .forEach(System.out::println);
    }
}
