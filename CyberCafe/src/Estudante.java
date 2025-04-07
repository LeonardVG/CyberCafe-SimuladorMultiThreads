import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Estudante extends Cliente {
    public Estudante(GerenciadorRecursos gerenciador) {
        super(gerenciador.getNovoIdEstudante(), gerenciador);
    }

    @Override
    public void usarRecursos() {
        try {
            System.out.println("Estudante " + id + " tentando adquirir recursos...");

            if (gerenciador.adquirirRecursos(this, 1, 0, 0)) {
                System.out.println("Estudante " + id + " está usando PC.");
                Thread.sleep(usoMaximo); // Simula o uso dos recursos
                gerenciador.liberarRecursos(1, 0, 0);
                System.out.println("Estudante " + id + " liberou PC.");
            } else {
                System.out.println("Estudante " + id + " não conseguiu recursos.");
            }
        } catch (InterruptedException e) {
            System.err.println("Erro no Estudante " + id + ": " + e.getMessage());
        }
    }
}