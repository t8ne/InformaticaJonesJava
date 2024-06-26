/**
 * A classe Board representa o tabuleiro do jogo.
 *
 * <p>Contém métodos para inicializar, exibir e manipular o tabuleiro.</p>
 *
 * @author António Rebelo - Nº28837 - ECGM
 */
public class Board {
    private final int width = 10;
    private final int height = 10;
    private char[][] board;

    /**
     * Construtor da classe Board.
     * Inicializa o tabuleiro chamando o método initializeBoard.
     */
    public Board() {
        board = new char[height][width];
        initializeBoard();
    }

    /**
     * Inicializa o tabuleiro com espaços em branco e adiciona paredes e objetos.
     */
    private void initializeBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }
        addWalls();
        addObjects();
    }

    /**
     * Adiciona paredes ao tabuleiro.
     */
    private void addWalls() {
        for (int i = 0; i < width; i++) {
            board[0][i] = 'W';
            board[height - 1][i] = 'W';
        }
        for (int i = 0; i < height; i++) {
            board[i][0] = 'W';
            board[i][width - 1] = 'W';
        }
        board[2][2] = 'W';
        board[2][3] = 'W';
        board[2][4] = 'W';
        board[4][6] = 'W';
        board[5][6] = 'W';
        board[6][6] = 'W';
        board[6][3] = 'W';
        board[7][3] = 'W';
        board[8][3] = 'W';
        board[8][4] = 'W';
        board[8][5] = 'W';
        board[8][6] = 'W';
    }

    /**
     * Adiciona objetos ao tabuleiro.
     */
    private void addObjects() {
        board[1][1] = 'E';
        board[3][4] = 'V';
        board[5][5] = 'T';
        board[6][7] = 'P';
        board[8][2] = 'J';
        board[3][2] = 'E';
        board[7][1] = 'V';
        board[2][7] = 'V';
        board[4][2] = 'E';
    }

    /**
     * Exibe o tabuleiro no console, mostrando a posição do jogador.
     *
     * @param playerX A posição X do jogador.
     * @param playerY A posição Y do jogador.
     */
    public void display(int playerX, int playerY) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == playerY && j == playerX) {
                    System.out.print('I' + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Exibe o conteúdo das células ao redor da posição especificada.
     *
     * @param x A posição X.
     * @param y A posição Y.
     */
    public void lookAround(int x, int y) {
        System.out.println("Olhando ao redor...");
        if (y > 0) System.out.println("Cima: " + board[y - 1][x]);
        if (y < height - 1) System.out.println("Baixo: " + board[y + 1][x]);
        if (x > 0) System.out.println("Esquerda: " + board[y][x - 1]);
        if (x < width - 1) System.out.println("Direita: " + board[y][x + 1]);
    }

    /**
     * Verifica se é possível mover-se em uma determinada direção.
     *
     * @param x A posição X inicial.
     * @param y A posição Y inicial.
     * @param steps O número de passos a serem dados.
     * @param direction A direção do movimento ('C', 'B', 'D', 'E').
     * @return true se o movimento for possível, false caso contrário.
     */
    public boolean isMovable(int x, int y, int steps, char direction) {
        switch (direction) {
            case 'C':
                return isMovableInternal(x, y, steps, -1, 0);
            case 'B':
                return isMovableInternal(x, y, steps, 1, 0);
            case 'D':
                return isMovableInternal(x, y, steps, 0, 1);
            case 'E':
                return isMovableInternal(x, y, steps, 0, -1);
            default:
                return false;
        }
    }

    /**
     * Método auxiliar para verificar a possibilidade de movimento em uma direção específica.
     *
     * @param x A posição X inicial.
     * @param y A posição Y inicial.
     * @param steps O número de passos a serem dados.
     * @param deltaY A variação na coordenada Y por passo.
     * @param deltaX A variação na coordenada X por passo.
     * @return true se o movimento for possível, false caso contrário.
     */
    private boolean isMovableInternal(int x, int y, int steps, int deltaY, int deltaX) {
        for (int i = 1; i <= steps; i++) {
            int newX = x + i * deltaX;
            int newY = y + i * deltaY;
            if (newY < 0 || newY >= height || newX < 0 || newX >= width || board[newY][newX] == 'W') {
                return false;
            }
        }
        return true;
    }

    /**
     * Retorna o caractere na posição especificada do tabuleiro.
     *
     * @param x A posição X.
     * @param y A posição Y.
     * @return O caractere na posição (x, y).
     */
    public char getTile(int x, int y) {
        return board[y][x];
    }

    /**
     * Define o valor de uma célula específica no tabuleiro.
     *
     * @param x A posição X.
     * @param y A posição Y.
     * @param value O novo valor para a célula.
     */
    public void setTile(int x, int y, char value) {
        board[y][x] = value;
    }
}
