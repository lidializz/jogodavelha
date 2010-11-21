

/**
 * Class Fronteira
 */
public class Fronteira {


  static MenuJogoVelha menu = new MenuJogoVelha();
  static Scanner input = new Scanner(System.in);
  
  public Fronteira () { };
  

	
  public static void gerarMenuPrincipal(  )
  {
  
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


  /**
   */
  public static void gerarMenuInterface(  )
  {
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
				break;

			case MenuJogoVelha.VOLTAR:
				break;

			default:

				System.out.println("OPCAO INVALIDA!");
				break;
			}
		} while (opcao != MenuJogoVelha.VOLTAR);
	}

  public void main( String[] args )
  {
	gerarMenuPrincipal();
  }


}
