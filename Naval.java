
public class Naval {
    public static void main(String[] args) {
        
        int linha = 0, coluna = 0;
        String orientacao = " ";
        String[][] tabuleiro = Metodos.InicializarMatriz();
        String[][] tabuleiro2 = Metodos.InicializarMatriz2();

        Metodos.ImprimirMatriz(tabuleiro);

        Metodos.PosicionarNavio(tabuleiro, orientacao, linha, coluna, "Porta-Aviões", 4);
        Metodos.PortaAvioes(tabuleiro, orientacao, linha, coluna);
        Metodos.ImprimirMatriz(tabuleiro);
        

        Metodos.PosicionarNavio(tabuleiro, orientacao, linha, coluna, "Fragata", 3);
        Metodos.Fragata(tabuleiro, orientacao, linha, coluna);
        Metodos.ImprimirMatriz(tabuleiro);
        
        for (int i = 0; i < 3; i++) {

            Metodos.PosicionarNavio(tabuleiro, orientacao, linha, coluna, "Submarino", 2);
            Metodos.Submarino(tabuleiro, orientacao, linha, coluna);
            Metodos.ImprimirMatriz(tabuleiro);

            Metodos.PosicionarNavio(tabuleiro, orientacao, linha, coluna, "Bote", 1);
            Metodos.ImprimirMatriz(tabuleiro);
        }

        Metodos.ImprimirMatriz2(tabuleiro2);

        for (int i = 1; i < 31; i++ ) {

            boolean vitoria = false;

            Metodos.realizarAtaque(tabuleiro, tabuleiro2, linha, coluna);
            Metodos.ImprimirMatriz2(tabuleiro2);
            vitoria = Metodos.VerificarVitoria(tabuleiro2, vitoria);
            if (vitoria == true) {
                System.out.println("Parabéns Atacante, você venceu!");
                break;
            }

            if (i == 30) {
                System.out.println("Tentativas do atacante acabaram, o Criador venceu!");
            }
        }
    }
}
