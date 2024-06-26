import java.util.Scanner;

/**
 * A classe Intro exibe as instruções do jogo e inicia o jogo.
 *
 * @author António Rebelo - Nº28837 - ECGM
 */
public class Intro {
    /**
     * Exibe as instruções do jogo e pergunta ao jogador se deseja iniciar.
     */
    public void showInstructions() {
        System.out.println("Bem-vindo ao jogo Informática Jones e o Tablet Perdido!");
        System.out.println("Instruções do Jogo:");
        System.out.println();
        System.out.println("1. Movimente-se pelo tabuleiro usando os seguintes comandos:");
        System.out.println("   - C (Cima) seguido de um número (ex: C3 move 3 casas para cima)");
        System.out.println("   - B (Baixo) seguido de um número (ex: B3 move 3 casas para baixo)");
        System.out.println("   - D (Direita) seguido de um número (ex: D3 move 3 casas para a direita)");
        System.out.println("   - E (Esquerda) seguido de um número (ex: E3 move 3 casas para a esquerda)");
        System.out.println();
        System.out.println("2. Recolha objetos usando o comando R");
        System.out.println("3. Use o comando O para olhar ao redor e obter informações sobre o ambiente");
        System.out.println("4. O objetivo é encontrar o Tablet Perdido e chegar ao laboratório com o menor número de jogadas possível.");
        System.out.println("5. Sua energia diminui a cada 8 jogadas. Recolha Barras Energéticas para recuperar energia.");
        System.out.println("6. Evite o Veneno que reduz sua energia.");
        System.out.println("7. Todos os Comandos são digitados em CAPS-LOCK.");
        System.out.println();
        System.out.println("Letras no jogo:");
        System.out.println("   - 'I' : Informática Jones (você)");
        System.out.println("   - 'E' : Barras Energéticas (recupera energia)");
        System.out.println("   - 'V' : Veneno (reduz energia)");
        System.out.println("   - 'T' : Tablet Perdido (objetivo do jogo)");
        System.out.println("   - 'P' : Portal (permite o acesso direto ao Laboratório de Informática)");
        System.out.println("   - 'J' : Coordenador do Curso (permite o acesso direto ao Laboratório de Informática)");
        System.out.println("   - 'W' : Parede (obstáculo intransponível)");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja iniciar o jogo? (S/N): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("S")) {
            Game game = new Game();
            game.start();
        } else {
            System.out.println("Jogo encerrado.");
            scanner.close();
        }
    }
}
