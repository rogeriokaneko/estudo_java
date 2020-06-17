package br.com.digitalinnovation.one.NovidadesJava11;

import java.util.jar.JarOutputStream;

public class StringRepeat {
    public static void main(String[] args) {
        String nome = "Joao";
        String aux = "";

        for (int i = 0; i < 10; i++) {
            aux += nome;
        }

        System.out.println(aux);


        String auxRepeat = nome.repeat(10);
        System.out.println(auxRepeat);

    }
}
