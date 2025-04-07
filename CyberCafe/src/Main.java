import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        GerenciadorRecursos gerenciador = new GerenciadorRecursos(10, 6, 8);

        // Configuração da simulação
        int tempoSimulacaoSegundos = 30; // colocar 60 para 1 minuto real
        long tempoInicio = System.currentTimeMillis();
        long tempoSimulacao = tempoSimulacaoSegundos * 1000;//colocar 1000 para 1min

        while (System.currentTimeMillis() - tempoInicio < tempoSimulacao) {
            int tipoCliente = ThreadLocalRandom.current().nextInt(3);
            Cliente cliente;

            switch (tipoCliente) {
                case 0 -> cliente = new Gamer(gerenciador);
                case 1 -> cliente = new Freelancer(gerenciador);
                default -> cliente = new Estudante(gerenciador);
            }

            cliente.start();

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
            } catch (InterruptedException e) {
                System.err.println("Erro ao criar clientes.");
            }
        }

        // Aguardar um tempo para todas as threads terminarem
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println("Erro ao finalizar a simulação.");
        }

        // Exibe as estatísticas ao final
        gerenciador.exibirEstatisticas();
        gerenciador.escreverEstatisticasEmArquivo("estatisticas_finais.txt");
    }
}