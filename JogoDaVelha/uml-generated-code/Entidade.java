package jogo_velha;

public class Entidade {
	
	static char[][] matriz = new char[5][5];

	public static char[][] getMatriz() {
		return matriz;
	}
	
	public static void inicializarTabuleiro(char matriz[][]) {
		for (int i = 0; i < 5; i = i + 2) {
			matriz[i][1] = '|';
			matriz[i][3] = '|';
		}
		for (int i = 0; i < 5; i++) {
			matriz[1][i] = '-';
			matriz[3][i] = '-';
		}
		limparPosicoes(matriz);
	}
	
	public static void limparPosicoes(char matriz[][]) {
		for (int i = 0; i < 5; i = i + 2) {
			for (int j = 0; j < 5; j = j + 2) {
				matriz[i][j] = ' ';
			}

		}

	}

}
