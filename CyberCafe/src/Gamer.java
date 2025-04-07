import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Gamer extends Cliente {
    public Gamer(GerenciadorRecursos gerenciador) {
        super(gerenciador.getNovoIdGamer(), gerenciador);
    }

    @Override
    public void usarRecursos() {
        try {
            System.out.println("Gamer " + id + " tentando adquirir recursos...");

            // Gamer prioriza PC e Headset VR
            if (gerenciador.adquirirRecursos(this, 1, 1, 0)) {
                System.out.println("Gamer " + id + " está usando PC e Headset VR.");
                Thread.sleep(usoMaximo); // Simula o uso dos recursos
                gerenciador.liberarRecursos(1, 1, 0);
                System.out.println("Gamer " + id + " liberou PC e Headset VR.");
            } else {
                System.out.println("Gamer " + id + " não conseguiu recursos.");
            }
        } catch (InterruptedException e) {
            System.err.println("Erro no Gamer " + id + ": " + e.getMessage());
        }
    }
}