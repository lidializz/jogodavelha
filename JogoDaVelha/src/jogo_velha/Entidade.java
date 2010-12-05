package jogo_velha;

import java.util.Random;

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

	public boolean verificarTabuleiroOcupado() {// vai verificar se o
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
	
	public static boolean verificarFimJogo(){
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
	

	public static boolean verificarRoboGanhador() {
		if (((matriz[0][0] == 'o') && (matriz[0][0] == matriz[0][2]) && (matriz[0][2] == matriz[0][4]))
				|| ((matriz[2][0] == 'o') && (matriz[2][0] == matriz[2][2]) && (matriz[2][2] == matriz[2][4]))
				|| ((matriz[4][0] == 'o') && (matriz[4][0] == matriz[4][2]) && (matriz[4][2] == matriz[4][4]))
				|| ((matriz[0][0] == 'o') && (matriz[0][0] == matriz[2][0]) && (matriz[2][0] == matriz[4][0]))
				|| ((matriz[0][2] == 'o') && (matriz[0][2] == matriz[2][2]) && (matriz[2][2] == matriz[4][2]))
				|| ((matriz[0][4] == 'o') && (matriz[0][4] == matriz[2][4]) && (matriz[2][4] == matriz[4][4]))
				|| ((matriz[0][0] == 'o') && (matriz[0][0] == matriz[2][2]) && (matriz[2][2] == matriz[4][4]))
				|| ((matriz[4][0] == 'o') && (matriz[4][0] == matriz[2][2]) && (matriz[2][2] == matriz[0][4])))

			return true;
		else
			return false;

	}
	public void realizarJogadaRobo() {
		Random r = new Random();
		int i = (0 + r.nextInt(3)) + 1;
		int j = (0 + r.nextInt(3)) + 1;

		while (verificaPosicaoOcupada(i, j) != false) {
			i = (0 + r.nextInt(3)) + 1;
			j = (0 + r.nextInt(3)) + 1;
		}
		marcarJogada(i, j, 'o');
		
	}
	
	public void realizarJogadaRoboDificil(){
		if(((matriz[0][0] == 'o') && (matriz[0][2] == 'o' )))
			marcarJogada(1, 3, 'o');		
		if(((matriz[0][0] == 'o') && (matriz[0][4] == 'o' )))
			marcarJogada(1, 2, 'o');
		if(((matriz[0][2] == 'o') && (matriz[0][4] == 'o' )))
			marcarJogada(1, 1, 'o');
		if(((matriz[2][0] == 'o') && (matriz[2][2] == 'o' )))
			marcarJogada(2, 3, 'o');
		if(((matriz[2][0] == 'o') && (matriz[2][4] == 'o' )))
			marcarJogada(2, 2, 'o');
		if(((matriz[2][2] == 'o') && (matriz[2][4] == 'o' )))
			marcarJogada(2, 1, 'o');
		if(((matriz[4][0] == 'o') && (matriz[4][2] == 'o' )))
			marcarJogada(3, 3, 'o');
		if(((matriz[4][0] == 'o') && (matriz[4][4] == 'o' )))
			marcarJogada(3, 2, 'o');
		if(((matriz[4][2] == 'o') && (matriz[4][4] == 'o' )))
			marcarJogada(3, 1, 'o');
		if(((matriz[0][0] == 'o') && (matriz[2][0] == 'o' )))
			marcarJogada(3, 1, 'o');
		if(((matriz[0][0] == 'o') && (matriz[4][0] == 'o' )))
			marcarJogada(2, 1, 'o');
		if(((matriz[2][0] == 'o') && (matriz[4][0] == 'o' )))
			marcarJogada(1, 1, 'o');
		if(((matriz[0][2] == 'o') && (matriz[2][2] == 'o' )))
			marcarJogada(3, 2, 'o');
		if(((matriz[0][2] == 'o') && (matriz[4][2] == 'o' )))
			marcarJogada(2, 2, 'o');
		if(((matriz[2][2] == 'o') && (matriz[4][2] == 'o' )))
			marcarJogada(1, 2, 'o');
		if(((matriz[0][4] == 'o') && (matriz[2][4] == 'o' )))
			marcarJogada(3, 3, 'o');
		if(((matriz[0][4] == 'o') && (matriz[4][4] == 'o' )))
			marcarJogada(2, 3, 'o');
		if(((matriz[2][4] == 'o') && (matriz[4][4] == 'o' )))
			marcarJogada(1, 3, 'o');
		if(((matriz[0][0] == 'o') && (matriz[2][2] == 'o' )))
			marcarJogada(3, 3, 'o');
		if(((matriz[0][0] == 'o') && (matriz[4][4] == 'o' )))
			marcarJogada(2, 2, 'o');
		if(((matriz[2][2] == 'o') && (matriz[4][4] == 'o' )))
			marcarJogada(1, 1, 'o');
		if(((matriz[4][0] == 'o') && (matriz[2][2] == 'o' )))
			marcarJogada(1, 3, 'o');
		if(((matriz[4][0] == 'o') && (matriz[0][4] == 'o' )))
			marcarJogada(2, 2, 'o');
		if(((matriz[2][2] == 'o') && (matriz[0][4] == 'o' )))
			marcarJogada(3, 1, 'o');
		
		
		realizarJogadaRobo();
		
	}
}

	


