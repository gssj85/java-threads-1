package br.alura.com.br.imprime_numeros;

public class ImprimeNumerosMain {
    public static void main(String[] args) {
        new Thread(new ImprimeNumerosRunnable()).start();
        new Thread(new ImprimeNumerosRunnable()).start();
    }
}
