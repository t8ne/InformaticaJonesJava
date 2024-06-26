import java.util.Scanner;

/**
 * A classe Game representa a lógica do jogo.
 *
 * <p>Contém métodos para iniciar e processar comandos do jogador.</p>
 *
 * @author António Rebelo - Nº28837 - ECGM
 */
public class Game {
    private Board board;
    private Player player;
    private boolean isRunning;
    private int moves;

    /**
     * Construtor da classe Game.
     * Inicializa o tabuleiro, jogador e configura o estado inicial do jogo.
     */
    public Game() {
        this.board = new Board();
        this.player = new Player();
        this.isRunning = true;
        this.moves = 0;
    }

    /**
     * Inicia o loop principal do jogo.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iniciando o jogo...");

        while (isRunning) {
            board.display(player.getX(), player.getY());
            System.out.print("Digite um comando: ");
            String command = scanner.nextLine();
            processCommand(command);
        }

        scanner.close();
    }

    /**
     * Processa o comando do jogador.
     *
     * @param command O comando inserido pelo jogador.
     */
    private void processCommand(String command) {
        if (command.length() == 0) {
            System.out.println("Comando inválido. Por favor, tente novamente.");
            return;
        }

        char action = command.charAt(0);
        int steps = 1;
        if (command.length() > 1) {
            try {
                steps = Integer.parseInt(command.substring(1));
            } catch (NumberFormatException e) {
                System.out.println("Número inválido no comando. Usando passo único.");
            }
        }

        switch (action) {
            case 'C':
                player.moveUp(board, steps);
                break;
            case 'B':
                player.moveDown(board, steps);
                break;
            case 'D':
                player.moveRight(board, steps);
                break;
            case 'E':
                player.moveLeft(board, steps);
                break;
            case 'R':
                player.collectItem(board);
                break;
            case 'O':
                board.lookAround(player.getX(), player.getY());
                break;
            default:
                System.out.println("Não sei o que queres");
                break;
        }

        moves++;
        player.updateEnergy(moves);

        if (player.getEnergy() <= 0) {
            System.out.println("Você ficou sem energia. Fim de jogo!");
            isRunning = false;
        } else if (player.hasWon()) {
            System.out.println("Parabéns! Você encontrou o Tablet Perdido e venceu o jogo!");
            isRunning = false;
        }
    }
}
