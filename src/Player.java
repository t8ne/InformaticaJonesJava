/**
 * A classe Player representa o jogador no jogo.
 *
 * <p>Contém métodos para movimentação, coleta de itens e atualização de energia.</p>
 *
 * @author António Rebelo - Nº28837 - ECGM
 */
public class Player {
    private int x;
    private int y;
    private int energy;
    private boolean hasTablet;

    /**
     * Construtor da classe Player.
     * Inicializa o jogador na posição inicial com energia cheia.
     */
    public Player() {
        this.x = 1;
        this.y = 1;
        this.energy = 100;
        this.hasTablet = false;
    }

    /**
     * Move o jogador para cima.
     *
     * @param board O tabuleiro do jogo.
     * @param steps O número de passos a serem dados.
     */
    public void moveUp(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'C')) {
            y -= steps;
            System.out.println("Movido para cima.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

    /**
     * Move o jogador para baixo.
     *
     * @param board O tabuleiro do jogo.
     * @param steps O número de passos a serem dados.
     */
    public void moveDown(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'B')) {
            y += steps;
            System.out.println("Movido para baixo.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

    /**
     * Move o jogador para a direita.
     *
     * @param board O tabuleiro do jogo.
     * @param steps O número de passos a serem dados.
     */
    public void moveRight(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'D')) {
            x += steps;
            System.out.println("Movido para a direita.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

    /**
     * Move o jogador para a esquerda.
     *
     * @param board O tabuleiro do jogo.
     * @param steps O número de passos a serem dados.
     */
    public void moveLeft(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'E')) {
            x -= steps;
            System.out.println("Movido para a esquerda.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

    /**
     * Coleta o item na posição atual do jogador.
     *
     * @param board O tabuleiro do jogo.
     */
    public void collectItem(Board board) {
        char tile = board.getTile(x, y);
        switch (tile) {
            case 'E':
                energy += 20;
                board.setTile(x, y, ' ');
                System.out.println("Barras Energéticas recolhidas! Energia aumentada.");
                break;
            case 'V':
                energy -= 20;
                board.setTile(x, y, ' ');
                System.out.println("Você foi envenenado! Energia reduzida.");
                break;
            case 'T':
                hasTablet = true;
                board.setTile(x, y, ' ');
                System.out.println("Você encontrou o Tablet Perdido! Vá para o laboratório para vencer.");
                break;
            case 'P':
                if (hasTablet) {
                    System.out.println("Você usou o Portal e venceu o jogo!");
                    System.exit(0); // Termina o jogo quando o jogador vence
                } else {
                    System.out.println("Você encontrou o Portal, mas precisa do Tablet para usá-lo.");
                }
                break;
            case 'J':
                if (hasTablet) {
                    System.out.println("Você encontrou o Coordenador do Curso e venceu o jogo!");
                    System.exit(0); // Termina o jogo quando o jogador vence
                } else {
                    System.out.println("Você encontrou o Coordenador do Curso, mas precisa do Tablet para vencer.");
                }
                break;
            default:
                System.out.println("Nada para recolher aqui.");
                break;
        }
    }

    /**
     * Atualiza a energia do jogador após um certo número de movimentos.
     *
     * @param moves O número de movimentos realizados pelo jogador.
     */
    public void updateEnergy(int moves) {
        if (moves % 8 == 0) {
            energy -= 20;
            System.out.println("Energia reduzida devido ao tempo. Energia atual: " + energy + "%");
        }
    }

    /**
     * Retorna a posição X do jogador.
     *
     * @return A posição X.
     */
    public int getX() {
        return x;
    }

    /**
     * Retorna a posição Y do jogador.
     *
     * @return A posição Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Retorna a energia atual do jogador.
     *
     * @return A energia atual.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Verifica se o jogador venceu o jogo.
     *
     * @return true se o jogador venceu, false caso contrário.
     */
    public boolean hasWon() {
        return hasTablet && (x == 6 && y == 7); // coordenadas do laboratório
    }
}
