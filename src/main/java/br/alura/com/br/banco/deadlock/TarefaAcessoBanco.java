package br.alura.com.br.banco.deadlock;

public class TarefaAcessoBanco implements Runnable {
    private PoolDeConexao pool;

    private GerenciadorDeTransacao tx;

    public TarefaAcessoBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("peguei a chave do pool");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("começando gerenciar tx");
                tx.begin();
            }
        }
    }
}
