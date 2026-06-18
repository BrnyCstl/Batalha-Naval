import java.util.Scanner;

public class Metodos {

    public static String[][] InicializarMatriz() {
        String[][] tabuleiro = new String[11][11];

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                tabuleiro[i][j] = "~";
            }
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 11; j++) {
                tabuleiro[i][j] = String.valueOf(j);
            }
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 1; j++) {
                tabuleiro[i][j] = String.valueOf(i);
            }
        }
        return tabuleiro;
    }

    public static String[][] InicializarMatriz2() {
        String[][] tabuleiro2 = new String[11][11];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11  ; j++) {
                tabuleiro2[i][j] = "~";
            }
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 11; j++) {
                tabuleiro2[i][j] = String.valueOf(j);
            }
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 1; j++) {
                tabuleiro2[i][j] = String.valueOf(i);
            }
        }
        return tabuleiro2;
    }

    public static String[][] ImprimirMatriz2(String[][] tabuleiro2) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(tabuleiro2[i][j] + " ");
            }
            System.out.println();
        }
        return tabuleiro2;
    }

    public static void ImprimirMatriz(String[][] tabuleiro) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void PosicionarNavio(String[][] tabuleiro, String orientacao, int linha, int coluna, String Navio, int tamanho) {
        boolean verificacao = false;

        do {
            Scanner Leitura = new Scanner(System.in);
            String navio = Navio;

            do {
                System.out.println("Digite as coordenadas para posicionar o " + Navio + ":");
                System.out.print("Linha: ");
                while (!Leitura.hasNextInt()) {
                    System.out.println("Linha inválida! Digite um número:");
                    Leitura.next();
                }
                linha = Leitura.nextInt();
                System.out.print("Coluna: ");
                while (!Leitura.hasNextInt()) {
                    System.out.println("Coluna inválida! Digite um número:");
                    Leitura.next();
                }
                coluna = Leitura.nextInt();

                if (linha < 1 || linha > 10 || coluna < 1 || coluna > 10) {
                    System.out.println("Coordenadas inválidas! Digite valores entre 1 e 10.");
                }

            } while (linha < 1 || linha > 10 || coluna < 1 || coluna > 10);

            if (navio.equalsIgnoreCase("Bote")) {

                System.out.println(
                        "Bote possui 1 de tamanho, portanto não necessita de orientação. Ele será posicionado na coordenada escolhida.");
                ;

            } else {

                do{
                    System.out.println("Digite a orientação para posicionar o " + Navio + ": (Digite a letra correspondente a direção: N, S, L, O, NE, SE, NO, SO)");
                    orientacao = Leitura.next();

                    if (!orientacao.equalsIgnoreCase("N") && !orientacao.equalsIgnoreCase("S") && !orientacao.equalsIgnoreCase("L") && !orientacao.equalsIgnoreCase("O") && !orientacao.equalsIgnoreCase("NE") && !orientacao.equalsIgnoreCase("SE") && !orientacao.equalsIgnoreCase("NO") && !orientacao.equalsIgnoreCase("SO")) {
                        System.out.println("Orientação inválida! Digite uma das seguintes opções: N, S, L, O, NE, SE, NO, SO.");
                    }

                } while (!orientacao.equalsIgnoreCase("N") && !orientacao.equalsIgnoreCase("S") && !orientacao.equalsIgnoreCase("L") && !orientacao.equalsIgnoreCase("O") && !orientacao.equalsIgnoreCase("NE") && !orientacao.equalsIgnoreCase("SE") && !orientacao.equalsIgnoreCase("NO") && !orientacao.equalsIgnoreCase("SO"));

            }
            verificacao = Metodos.VerificarNavio(navio, tabuleiro, orientacao, linha, coluna);

            if (!verificacao) {
                System.out.println("Tente novamente com valores válidos.");
            }
        } while (!verificacao);

        System.out.println("Posição válida, navio posicionado com sucesso.");
        System.out.println("Tabuleiro atualizado:");

        if (Navio.equalsIgnoreCase("Porta-Aviões")) {
            Metodos.PortaAvioes(tabuleiro, orientacao, linha, coluna);
        } else if (Navio.equalsIgnoreCase("Fragata")) {
            Metodos.Fragata(tabuleiro, orientacao, linha, coluna);
        } else if (Navio.equalsIgnoreCase("Submarino")) {
            Metodos.Submarino(tabuleiro, orientacao, linha, coluna);
        } else if (Navio.equalsIgnoreCase("Bote")) {
            Metodos.Bote(tabuleiro, linha, coluna);
        } else {
            System.out.println("Tipo de navio inválido.");
        }
    }

    public static boolean VerificarNavio(String navio, String[][] tabuleiro, String orientacao, int linha, int coluna) {

        if (navio.equalsIgnoreCase("Porta-Aviões")) {

            if (linha < 1 || linha > 10 || coluna < 1 || coluna > 10) {
                System.out.println("Coordenadas fora do tabuleiro. Use valores de 1 a 10.");
                return false;
            }

            if (orientacao.equalsIgnoreCase("N") && linha < 4) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("S") && linha > 7) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("O") && coluna < 4) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("L") && coluna > 7) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("NE") && (linha < 4 || coluna > 7)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("SE") && (linha > 7 || coluna > 7)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("NO") && (linha < 4 || coluna < 4)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("SO") && (linha > 7 || coluna < 4)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            }
            return true;

        } else if (navio.equalsIgnoreCase("Fragata")) {

            if (tabuleiro[linha][coluna].equals("N")) {
                System.out.println("Já existe um navio nessa posição. Escolha outra coordenada.");
                return false;
            }

            if (linha < 1 || linha > 10 || coluna < 1 || coluna > 10) {
                System.out.println("Coordenadas fora do tabuleiro. Use valores de 1 a 10.");
                return false;
            }

            if (orientacao.equalsIgnoreCase("N") && linha < 3) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("S") && linha > 8) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("O") && coluna < 3) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("L") && coluna > 7) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("NE") && (linha < 3 || coluna > 8)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("SE") && (linha > 8 || coluna > 8)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("NO") && (linha < 3 || coluna < 3)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("SO") && (linha > 8 || coluna < 3)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            }

            return true;

        } else if (navio.equalsIgnoreCase("Submarino")) {

            if (tabuleiro[linha][coluna].equals("S")) {
                System.out.println("Já existe um navio nessa posição. Escolha outra coordenada.");
                return false;
            }

            if (linha < 0 || linha > 9 || coluna < 0 || coluna > 9) {
                System.out.println("Coordenadas fora do tabuleiro. Use valores de 0 a 9.");
                return false;
            }

            if (orientacao.equalsIgnoreCase("N") && linha < 2) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("S") && linha > 9) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("O") && coluna < 2) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("L") && coluna > 9) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("NE") && (linha < 2 || coluna > 9)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("SE") && (linha > 9 || coluna > 9)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("NO") && (linha < 2 || coluna < 2)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else if (orientacao.equalsIgnoreCase("SO") && (linha > 9 || coluna < 2)) {
                System.out.println(
                        "Não é possível posicionar o navio nessa direção, pois ultrapassa os limites do tabuleiro.");
                return false;
            } else {
                return true;
            }

        } else if (navio.equalsIgnoreCase("Bote")) {
            if (tabuleiro[linha][coluna].equals("N")) {
                System.out.println("Já existe um navio nessa posição. Escolha outra coordenada.");
                return false;
            }
            return true;
        } else {
            System.out.println("Tipo de navio inválido.");
            return false;
        }
    }

    public static String[][] PortaAvioes(String[][] tabuleiro, String orientacao, int linha, int coluna) {
        if (orientacao.equalsIgnoreCase("N")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha - i][coluna] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("S")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha + i][coluna] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("O")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha][coluna - i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("L")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("NE")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha - i][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("SE")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha + i][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("NO")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha - i][coluna - i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("SO")) {
            for (int i = 0; i < 4; i++) {
                tabuleiro[linha + i][coluna - i] = "N";
            }
        }
        return tabuleiro;
    }

    public static String[][] Fragata(String[][] tabuleiro, String orientacao, int linha, int coluna) {
        if (orientacao.equalsIgnoreCase("N")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha - i][coluna] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("S")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha + i][coluna] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("O")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha][coluna - i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("L")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("NE")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha - i][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("SE")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha + i][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("NO")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha - i][coluna - i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("SO")) {
            for (int i = 0; i < 3; i++) {
                tabuleiro[linha + i][coluna - i] = "N";
            }
        }
        return tabuleiro;
    }

    public static String[][] Submarino(String[][] tabuleiro, String orientacao, int linha, int coluna) {
        if (orientacao.equalsIgnoreCase("N")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha - i][coluna] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("S")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha + i][coluna] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("O")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha][coluna - i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("L")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("NE")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha - i][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("SE")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha + i][coluna + i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("NO")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha - i][coluna - i] = "N";
            }
        } else if (orientacao.equalsIgnoreCase("SO")) {
            for (int i = 0; i < 2; i++) {
                tabuleiro[linha + i][coluna - i] = "N";
            }
        }
        return tabuleiro;
    }

    public static String[][] Bote(String[][] tabuleiro, int linha, int coluna) {
        tabuleiro[linha][coluna] = "N";
        return tabuleiro;
    }

    public static String[][] realizarAtaque(String[][] tabuleiro, String[][] tabuleiro2, int linha, int coluna) {
        Scanner leitura = new Scanner(System.in);

        do{
            System.out.println("Digite as coordenadas para realizar um ataque:");
            System.out.print("Linha: ");
            while (!leitura.hasNextInt()) {
                System.out.println("Linha inválida! Digite um número:");
                leitura.next();
            }
            linha = leitura.nextInt();

            System.out.print("Coluna: ");
            while (!leitura.hasNextInt()) {
                System.out.println("Coluna inválida! Digite um número:");
                leitura.next();
            }
            coluna = leitura.nextInt();

            if (linha < 0 || linha > 10 || coluna < 0 || coluna > 10) {
                System.out.println("Coordenadas inválidas! Digite valores entre 0 e 10.");
            }

        } while (linha < 0 || linha > 10 || coluna < 0 || coluna > 10);

        if (tabuleiro[linha][coluna].equals("N") && !tabuleiro2[linha][coluna].equals("X")) {
            System.out.println("Acertou um navio!");
            tabuleiro2[linha][coluna] = "X";
        } else if (tabuleiro[linha][coluna].equals("~") && !tabuleiro2[linha][coluna].equals("O")) {
            System.out.println("Água!");
            tabuleiro2[linha][coluna] = "O";
        } else if (tabuleiro2[linha][coluna].equals("X") || tabuleiro2[linha][coluna].equals("O")) {
            System.out.println("Essa posição já foi atacada. Tente outra coordenada.");
        }
        return tabuleiro2;
    }

    public static Boolean VerificarVitoria(String[][] tabuleiro2, boolean ganhador) {
        
        ganhador = false;
        int quantidadeGanhadores = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if(tabuleiro2[i][j] == "X"){
                    quantidadeGanhadores += 1;
                }

                if (quantidadeGanhadores == 16){
                    ganhador = true;
                } else{ganhador = false;}
            }
        }
        return(ganhador);
    }
}
