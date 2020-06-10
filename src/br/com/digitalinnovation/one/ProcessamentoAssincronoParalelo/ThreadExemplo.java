package br.com.digitalinnovation.one.ProcessamentoAssincronoParalelo;

public class ThreadExemplo {
    public static void main(String[] args) {
//        BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
//        BarraDeCarregamento3 barraDeCarregamento3 = new BarraDeCarregamento3();
//
//        barraDeCarregamento2.start();
//        barraDeCarregamento3.start();

        GeradorPDF iniciarGeradorPDF = new GeradorPDF();
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPDF);

        iniciarGeradorPDF.start();
        iniciarBarraDeCarregamento.start();

    }
}

class GeradorPDF extends Thread{
    @Override
    public void run() {

        try {
            System.out.println("Iniciando Geração de PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread{
    private Thread iniciadorGeradorPDF;

    public BarraDeCarregamento(Thread iniciarGeradorPDF) {
        this.iniciadorGeradorPDF = iniciarGeradorPDF;
    }

    @Override
    public void run() {

        try {
            while (true){
                if(!iniciadorGeradorPDF.isAlive()){
                    break;
                }

                System.out.println("Loading ...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento2 extends Thread{
    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(3000);
            System.out.println("Rodei BarraDeCarregamento2: " + this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento3 extends Thread{
    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(1000);
            System.out.println("Rodei BarraDeCarregamento3: " + this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}













