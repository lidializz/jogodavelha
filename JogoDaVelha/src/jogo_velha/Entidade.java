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

	
	public void marcarJogada(int i, int j, char simbolo) {
		i = (i - 1) * 2;
		j = (j - 1) * 2;
		matriz[i][j] = simbolo;
	}


	public boolean verificaPosicaoOcupada(int i, int j) {// vai verificar se a
		// posicao esta
		// ocupada
		i = (i - 1) * 2;
		j = (j - 1) * 2;
		if ((matriz[i][j] == 'x') || (matriz[i][j] == 'o'))
			return true; // ou seja nao pode ser usado
		else
			return false;
	}

	public boolean verificaTabuleiroOcupado() {// vai verificar se o
		// tabuleiro esta
		// todo ocupado (Forca Bruta)
		if ((matriz[0][0] == 'o' || matriz[0][0] == 'x')
				&& (matriz[0][2] == 'o' || matriz[0][2] == 'x')
				&& (matriz[0][4] == 'o' || matriz[0][4] == 'x')
				&& (matriz[2][0] == 'o' || matriz[2][0] == 'x')
				&& (matriz[2][2] == 'o' || matriz[2][2] == 'x')
				&& (matriz[2][4] == 'o' || matriz[2][4] == 'x')
				&& (matriz[4][0] == 'o' || matriz[4][0] == 'x')
				&& (matriz[4][2] == 'o' || matriz[4][2] == 'x')
				&& (matriz[4][4] == 'o' || matriz[4][4] == 'x'))
			return true;
		else
			return false;
	}
	
	public static boolean verificarGanhador(){
		if (((matriz[0][0] != ' ') && (matriz[0][0] == matriz[0][2]) && (matriz[0][2] == matriz[0][4]))
					|| ((matriz[2][0] != ' ') && (matriz[2][0] == matriz[2][2]) && (matriz[2][2] == matriz[2][4]))
					|| ((matriz[4][0] != ' ') && (matriz[4][0] == matriz[4][2]) && (matriz[4][2] == matriz[4][4]))
					|| ((matriz[0][0] != ' ') && (matriz[0][0] == matriz[2][0]) && (matriz[2][0] == matriz[4][0]))
					|| ((matriz[0][2] != ' ') && (matriz[0][2] == matriz[2][2]) && (matriz[2][2] == matriz[4][2]))
					|| ((matriz[0][4] != ' ') && (matriz[0][4] == matriz[2][4]) && (matriz[2][4] == matriz[4][4]))
					|| ((matriz[0][0] != ' ') && (matriz[0][0] == matriz[2][2]) && (matriz[2][2] == matriz[4][4]))
					|| ((matriz[4][0] != ' ') && (matriz[4][0] == matriz[2][2]) && (matriz[2][2] == matriz[0][4])))

				return true;
			else
				return false;

		}
}

	


