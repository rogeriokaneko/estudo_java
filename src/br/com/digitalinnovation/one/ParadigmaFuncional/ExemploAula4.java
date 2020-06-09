package br.com.digitalinnovation.one.ParadigmaFuncional;

import java.util.HashMap;
import java.util.Map;

public class ExemploAula4 {

    static Map<Integer, Integer> MAPA_FATORIAL = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fatorial(5));

        System.out.println("**********************************************");

        System.out.println("Fatorial com Tail Call : " + fatorialComTailCall(5));

        System.out.println("**********************************************");
        long inicio = System.nanoTime();
        System.out.println(fatorialComMemoization(15));
        long fim = System.nanoTime();
        System.out.println("Fatorial com Memoization 1: " + (fim - inicio));

        inicio = System.nanoTime();
        System.out.println(fatorialComMemoization(15));
        fim = System.nanoTime();
        System.out.println("Fatorial com Memoization 2: " + (fim - inicio));


    }

    public static int fatorial(int valor){
        if(valor == 1){
            return valor;
        }else{
            return valor * fatorial((valor - 1));
        }
    }


    public static int fatorialComTailCall(int valor){
        return fatorialComTailCallAuxiliar(valor, 1);
    }

    public static int fatorialComTailCallAuxiliar(int valor, int numero){
        if(valor == 0){
            return numero;
        }
        return fatorialComTailCallAuxiliar((valor - 1), (numero * valor));
    }

    public static Integer fatorialComMemoization(Integer value){
        if(value == 1){
            return value;
        }else{
            if(MAPA_FATORIAL.containsKey(value)){
                return MAPA_FATORIAL.get(value);
            }else{
                Integer resultado = value * fatorialComMemoization(value - 1);
                MAPA_FATORIAL.put(value, resultado);
                return resultado;
            }
        }
    }

}


