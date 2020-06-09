package br.com.digitalinnovation.one.ParadigmaFuncional;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class ExemploAula2 {

    public static void main(String[] args) {
        int[] valores = {1,2,3,4};
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 2)
                .forEach(numero -> System.out.println(numero));

        System.out.println(Arrays.toString(valores));

        for(int i = 0; i < valores.length; i++){
            if(valores[i] % 2 == 0){
                System.out.println(valores[i] * 2);
            }
        }


        System.out.println("*************************************************");

        BiPredicate<Integer, Integer> verificarSeEMaior =
                (parametro, valorComparacao) -> parametro > valorComparacao;

        System.out.println(verificarSeEMaior.test(13, 12));
        System.out.println(verificarSeEMaior.test(13, 12));

        System.out.println("*************************************************");

        int valor = 20;
        UnaryOperator<Integer> retornarDobro = v -> v * 2;
        System.out.println(retornarDobro.apply(valor));
        System.out.println(valor);

    }
}
