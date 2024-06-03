//Feito por: António Rebelo - Nº28837 - ECGM

public class Player {
    private int x;
    private int y;
    private int energy;
    private boolean hasTablet;

    public Player() {
        this.x = 1;
        this.y = 1;
        this.energy = 100;
        this.hasTablet = false;
    }

    public void moveUp(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'C')) {
            y -= steps;
            System.out.println("Movido para cima.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

    public void moveDown(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'B')) {
            y += steps;
            System.out.println("Movido para baixo.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

    public void moveRight(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'D')) {
            x += steps;
            System.out.println("Movido para a direita.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

    public void moveLeft(Board board, int steps) {
        if (board.isMovable(x, y, steps, 'E')) {
            x -= steps;
            System.out.println("Movido para a esquerda.");
        } else {
            System.out.println("Movimento inválido.");
        }
    }

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

    public void updateEnergy(int moves) {
        if (moves % 8 == 0) {
            energy -= 20;
            System.out.println("Energia reduzida devido ao tempo. Energia atual: " + energy + "%");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean hasWon() {
        // Condição de vitória: jogador deve ter o tablet e estar no laboratório de informática
        return hasTablet && (x == 6 && y == 7); // coordenadas do laboratório
    }
}

