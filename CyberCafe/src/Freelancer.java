import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Freelancer extends Cliente {
    public Freelancer(GerenciadorRecursos gerenciador) {
        super(gerenciador.getNovoIdFreelancer(), gerenciador);
    }

    @Override
    public void usarRecursos() {
        try {
            System.out.println("Freelancer " + id + " tentando adquirir recursos...");

            if (gerenciador.adquirirRecursos(this, 1, 0, 1)) {
                System.out.println("Freelancer " + id + " está usando PC e Cadeira.");
                Thread.sleep(usoMaximo); // Simula o uso dos recursos
                gerenciador.liberarRecursos(1, 0, 1);
                System.out.println("Freelancer " + id + " liberou PC e Cadeira.");
            } else {
                System.out.println("Freelancer " + id + " não conseguiu recursos.");
            }
        } catch (InterruptedException e) {
            System.err.println("Erro no Freelancer " + id + ": " + e.getMessage());
        }
    }
}