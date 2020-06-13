package br.com.digitalinnovation.one.ProcessamentoAssincronoParalelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExemplo {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa(new Quarto());
//        casa.obterAfazeresDaCasa()
//                .forEach(atividade -> threadPool.execute(() -> atividade.realizar()));

        List<? extends Future<String>> futuros =

        new CopyOnWriteArrayList<Future<String>>(casa.obterAfazeresDaCasa().stream()
                .map(atividade -> threadPool.submit(() -> {
                    try {
                        return atividade.realizar();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    return null;
                }))
                .collect(Collectors.toList()));

        while(true){
            int numeroDeAtividadesNaoFinalizadas = 0;

            for(Future<?> futuro : futuros){
                if(futuro.isDone()){
                    try {
                        System.out.println("Parabéns você terminou de " + futuro.get());
                        futuros.remove(futuro);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }
                }else{
                    numeroDeAtividadesNaoFinalizadas ++;
                }
            }

            if(futuros.stream().allMatch(Future::isDone)){
                break;
            }

            System.out.println("Número de atividades não finalizadas :: " + numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(500);
        }

        threadPool.shutdown();
    }

}

class Casa{
    private List<Comodo> comodos;

    Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }

    List<Atividade> obterAfazeresDaCasa(){
        return this.comodos.stream()
                .map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade{
    String realizar() throws InterruptedException;
}

abstract class Comodo{
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo{
    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::arrumarACama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private String arrumarGuardaRoupa() throws InterruptedException {
       Thread.sleep(5000);
       String arrumarOGuardaRoupa = "Arrumar o Guarda Roupa";
       System.out.println(arrumarOGuardaRoupa);
       return arrumarOGuardaRoupa;
    }

    private String varrerOQuarto() throws InterruptedException {
        Thread.sleep(7000);
        String varrerOQuarto = "Varrer o Quarto";
        System.out.println(varrerOQuarto);
        return varrerOQuarto;
    }

    private String arrumarACama() throws InterruptedException {
        Thread.sleep(10000);
        String arrumarACama = "Arrumar a Cama";
        System.out.println(arrumarACama);
        return arrumarACama;
    }
}

