import java.util.concurrent.Semaphore;

public abstract class Cliente extends Thread {
    protected GerenciadorRecursos gerenciador; // Gerenciador dos recursos
    protected int id; // Identificador único do cliente
    protected long startTime; // Tempo de chegada do cliente para estatísticas
    protected long usoMaximo; // Tempo máximo de uso dos recursos

    public Cliente(int id, GerenciadorRecursos gerenciador) {
        this.id = id;
        this.gerenciador = gerenciador;
        this.startTime = System.currentTimeMillis(); // Marca o momento da chegada
        this.usoMaximo = 2500; // Tempo máximo de uso dos recursos (2.5 segundos)
    }

    // Método abstrato para as subclasses implementarem
    public abstract void usarRecursos();

    @Override
    public void run() {
        usarRecursos();
    }
}
