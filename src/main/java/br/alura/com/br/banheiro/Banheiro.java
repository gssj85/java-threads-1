package br.alura.com.br.banheiro;

public class Banheiro {
    private boolean estaSujo = true;

    public void fazNumero1() {
        String nome = getThreadName();

        System.out.println(nome + " batendo na porta.");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro.");

            while (estaSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa rápida.");

            dormeUmPouco(5000);

            this.estaSujo = true;

            System.out.println(nome + " dando descarga.");
            System.out.println(nome + " lavando mão.");
            System.out.println(nome + " saindo.");
        }
    }

    public void fazNumero2() {
        String nome = getThreadName();

        System.out.println(nome + " batendo na porta.");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro.");

            while (estaSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada.");

            dormeUmPouco(10000);

            this.estaSujo = true;

            System.out.println(nome + " dando descarga.");
            System.out.println(nome + " lavando mão.");
            System.out.println(nome + " saindo.");
        }
    }

    private static void dormeUmPouco(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

    private void esperaLaFora(String nome) {
        System.out.println(nome + ", eca, banheiro tá sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void limpa() {
        String nome = getThreadName();
        System.out.println(nome + " batendo na porta.");

        if (!estaSujo) {
            System.out.println(nome + ", não está sujo, vou sair.");
            return;
        }

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro.");
            System.out.println(nome + " limpando banheiro.");
            this.estaSujo = false;

            dormeUmPouco(13000);

            this.notifyAll();

            System.out.println(nome + " saindo do banheiro.");
        }

    }
}
