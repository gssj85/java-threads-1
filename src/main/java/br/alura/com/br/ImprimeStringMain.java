package br.alura.com.br;

public class ImprimeStringMain {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("=== TESTE===");
            }
        }).start();
    }
}
