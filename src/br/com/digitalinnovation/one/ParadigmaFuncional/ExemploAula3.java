package br.com.digitalinnovation.one.ParadigmaFuncional;

public class ExemploAula3 {

    public static void main(String[] args) {

        //
        Funcao1 colocarPrefixoSenhorNaString1 = new Funcao1(){
            @Override
            public String gerar(String valor) {
                return "Sr. " + valor;
            }
        };

        Funcao1 colocarPrefixoSenhorNaString = valor -> "Sr. " + valor;

        System.out.println(colocarPrefixoSenhorNaString1.gerar("teste"));
        System.out.println(colocarPrefixoSenhorNaString.gerar("teste"));

        System.out.println("************************************************");

        Funcao2 funcao2 = valor -> {
            System.out.println(valor);
            System.out.println(valor);
        };
        funcao2.gerar("Rogerio");
    }

}

@FunctionalInterface
interface Funcao1{
    String gerar(String valor);
}

@FunctionalInterface
interface Funcao2{
    void gerar(String valor);
}