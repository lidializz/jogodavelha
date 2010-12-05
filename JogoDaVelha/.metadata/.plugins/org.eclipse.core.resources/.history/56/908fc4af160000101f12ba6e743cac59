package jogo_velha;

import java.util.Scanner; //Pra poder ler a entrada do console

public class Fronteira {

	public static Controle controle = new Controle();
	static MenuJogoVelha menu = new MenuJogoVelha();
	static Scanner input = new Scanner(System.in);

	public static boolean verificarPosicaoInvalida(int i, int j) {
		if ((i == 1 && j == 1) || (i == 1 && j == 2) || (i == 1 && j == 3)
				|| (i == 2 && j == 1) || (i == 2 && j == 2)
				|| (i == 2 && j == 3) || (i == 3 && j == 1)
				|| (i == 3 && j == 2) || (i == 3 && j == 3))
			return false;
		else
			return true;
	}

	public static void gerarMenuInterface() {
		int opcao;
		do {
			MenuJogoVelha.mostrarMenuInterface();
			opcao = input.nextInt();

			switch (opcao) {

			case MenuJogoVelha.INTERFACE_GRAFICA:
				System.out.println("Interface nao disponivel\n");
				break;

			case MenuJogoVelha.INTERFACE_TEXTO:
				System.out.println("Interface de Texto Selecionada");
				gerarMenuOponente();
				break;

			case MenuJogoVelha.VOLTAR:
				break;

			default:

				System.out.println("OPCAO INVALIDA!");
				break;
			}
		} while (opcao != MenuJogoVelha.VOLTAR);
	}

	public static void gerarMenuPrincipal() {

		int opcao;

		do {
			MenuJogoVelha.mostrarMenuPrincipal();
			opcao = input.nextInt();

			switch (opcao) {

			case MenuJogoVelha.TIPO_INTERFACE:
				gerarMenuInterface();
				break;

			case MenuJogoVelha.SAIR:
				break;

			default:
				System.out.println("OPCAO INVALIDA!");
				break;
			}
		} while (opcao != MenuJogoVelha.SAIR);
	}

	public static void gerarMenuOponente() {
		int opcao;

		do {
			MenuJogoVelha.mostrarMenuOponente();// aqui o jogador vai escolher o
			// tipo de oponente
			opcao = input.nextInt();

			switch (opcao) {
			case MenuJogoVelha.OPONENTE_HUMANO:
				iniciarPartida(1);
				break;

			case MenuJogoVelha.OPONENTE_ROBO:
				gerarMenuNivelJogo();
				break;

			case MenuJogoVelha.VOLTAR:
				break;

			default:

				System.out.println("OPCAO INVALIDA!");
				break;
			}

		} while (opcao != MenuJogoVelha.VOLTAR);
	}

	public static void gerarMenuNivelJogo() {// Jogador escolhe o nivel do jogo
												// em que
		// quer jogar

		int opcao;

		do {
			MenuJogoVelha.displayNiveis();
			opcao = input.nextInt();

			switch (opcao) {
			case MenuJogoVelha.FACIL:
				iniciarPartida(2);
				break;

			case MenuJogoVelha.DIFICIL:
				iniciarPartida(3);
				break;

			case MenuJogoVelha.VOLTARNIVEL:
				break;

			default:
				System.out.println("OPCAO INVALIDA!");
				break;
			}

		} while (opcao != MenuJogoVelha.VOLTARNIVEL);

	}

	public static void imprimirTabuleiro(char matriz[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}

	public static void iniciarPartida(int opcao) {

		Controle.iniciarTabuleiro();
		switch(opcao) {
		case 1:
			jogarHumano();
			break;
		case 2:
			jogarRoboFacil();
			break;
		case 3:
			jogarRoboDificil();
			break;
		default:
			break;
		}
				
	}

	public static void reiniciar() { // neste metodo o jogador pode escolher pra
		// qual menu voltar
		int k = 3;
		System.out
				.println("Digite 0 para voltar ao menu principal ou 1 para iniciar uma nova partida");
		k = input.nextInt();
		while ((k != 0) && (k != 1)) {
			System.out.println("Opcao inexistente! Tente novamente...");
			k = input.nextInt();
		}
		if (k == 0) {
			gerarMenuPrincipal();
			System.exit(0);
		}
	}

	public static void jogarHumano() {
		int i, j;
		char simbolo = 'x';
		Controle.iniciarTabuleiro();
		while ((controle.verificarJogoTerminado() != true)
				&& (controle.verificarTabuleiroCheio() != true)) {
			imprimirTabuleiro(Controle.getMatriz());

			if (simbolo == 'x')
				System.out.println("\n\nJogador 1\n");
			else
				System.out.println("\n\nJogador 2\n");

			System.out.println("Digite a linha e a coluna de sua jogada: ");
			i = input.nextInt();
			j = input.nextInt();

			if (jogar(i, j, simbolo)) {
				if (simbolo == 'x')
					simbolo = 'o';
				else
					simbolo = 'x';
			}
		}
		imprimirTabuleiro(Controle.getMatriz());
		if (controle.verificarJogoTerminado() == true)
			if (simbolo == 'x')
				System.out.println("\nO jogador 2 venceu!\n");
			else
				System.out.println("\nO jogador 1 venceu!\n");
		else
			System.out.println("\nVelhouuu :p!\n");

		reiniciar();

	}

	public static void jogarRoboFacil() {

		int i, j;
		char simbolo = 'x';
		Controle.iniciarTabuleiro();
		while ((controle.verificarJogoTerminado() != true)
				&& (controle.verificarTabuleiroCheio() != true)) {
			imprimirTabuleiro(Controle.getMatriz());
			System.out.println("\n\nJogador Humano\n");

			System.out.println("Digite a linha e a coluna de sua jogada: ");
			i = input.nextInt();
			j = input.nextInt();

			if (jogar(i, j, simbolo)) {
				if ((controle.verificarTabuleiroCheio() != true)
						&& (controle.verificarJogoTerminado() != true))
					controle.jogarRobo();
			}
		}

		imprimirTabuleiro(Controle.getMatriz());
		if (controle.verificarJogoTerminado() == true) {
			if (controle.verificarRoboVencedor() == true)
				System.out.println("\nO jogador computador venceu!\n");
			else
				System.out.println("\nO jogador humano venceu!\n");
		} else
			System.out.println("\nVelhouuu :p!\n");

		reiniciar();
	}
	
	public static void jogarRoboDificil(){
		System.out.println("\nEm construcao...\n");
	}

	public static boolean jogar(int i, int j, char simbolo) {

		if (verificarPosicaoInvalida(i, j) == false) {
			if (controle.posicaoOcupada(i, j) == false) {
				controle.fazerJogada(i, j, simbolo);
				return true;
			} else
				System.out
						.println("\n\nPosicao ja ocupada! Jogue novamente...\n\n");
			return false;
		} else
			System.out.println("\n\nPosicao invalida\n\n");
		return false;
	}

	public static void main(String[] args) {

		gerarMenuPrincipal();
	}

}
