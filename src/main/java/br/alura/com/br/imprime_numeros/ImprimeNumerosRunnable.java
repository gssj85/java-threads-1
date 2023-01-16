package br.alura.com.br.imprime_numeros;

public class ImprimeNumerosRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            Thread threadAtual = Thread.currentThread();
            long id = threadAtual.getId();
            System.out.println(id + " - " + i);
        }
    }
}
