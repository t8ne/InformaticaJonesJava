//Feito por: António Rebelo - Nº28837 - ECGM

public class Board {
    private final int width = 10;
    private final int height = 10;
    private char[][] board;

    public Board() {
        board = new char[height][width];
        initializeBoard();
    }

    private void initializeBoard() {
        // Inicializar o tabuleiro com espaços em branco ou outros elementos
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }

        // Adicionar paredes e objetos conforme o exemplo
        addWalls();
        addObjects();
    }

    private void addWalls() {
        // Exemplo de paredes, pode ser ajustado conforme necessário
        for (int i = 0; i < width; i++) {
            board[0][i] = 'W';
            board[height - 1][i] = 'W';
        }
        for (int i = 0; i < height; i++) {
            board[i][0] = 'W';
            board[i][width - 1] = 'W';
        }

        // Adicionar paredes internas conforme necessário
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

    private void addObjects() {
        // Adicionando objetos ao tabuleiro conforme o exemplo fornecido
        board[1][1] = 'E'; // Barras Energéticas
        board[3][4] = 'V'; // Veneno
        board[5][5] = 'T'; // Tablet Perdido
        board[6][7] = 'P'; // Portal
        board[8][2] = 'J'; // Coordenador do Curso
        board[3][2] = 'E'; // Barras Energéticas
        board[7][1] = 'V'; // Veneno
        board[2][7] = 'V'; // Veneno
        board[4][2] = 'E'; // Barras Energéticas
    }

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

    public void lookAround(int x, int y) {
        System.out.println("Olhando ao redor...");
        if (y > 0) System.out.println("Cima: " + board[y - 1][x]);
        if (y < height - 1) System.out.println("Baixo: " + board[y + 1][x]);
        if (x > 0) System.out.println("Esquerda: " + board[y][x - 1]);
        if (x < width - 1) System.out.println("Direita: " + board[y][x + 1]);
    }

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

    private boolean isMovableInternal(int x, int y, int steps, int deltaY, int deltaX) {
        for (int i = 1; i <= steps; i++) {
            int newX = x + i * deltaX;
            int newY = y + i * deltaY;
            if (newY < 0 || newY >= height || newX < 0 || newX >= width || board[newY][newX] == 'W') {
                return false;
            }
            if (i < steps && board[newY][newX] == ' ') {
                continue;
            }
        }
        return true;
    }

    public char getTile(int x, int y) {
        return board[y][x];
    }

    public void setTile(int x, int y, char value) {
        board[y][x] = value;
    }
}
