

/**
 * Class Controle
 */
public class Controle {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public Controle () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

  /**
   */
  public static void iniciarTabuleiro(  )
  {
	Entidade.inicializarTabuleiro(getMatriz());
  }


  /**
   * @return       char
   */
  public static char getMatriz(  )
  {
	matriz = Entidade.getMatriz();
		return matriz;
  }


  /**
   * @return       boolean
   */
  public boolean jogoTerminado(  )
  {
	if (Entidade.verificarGanhador() == true)
			return true;
		else
			return false;
  }


  /**
   */
  public void jogaRobo(  )
  {
  }


  /**
   * @param        i
   * @param        j
   * @param        simbolo
   */
  public void fazerJogada( int i, int j, char simbolo )
  {
	entidade.marcarJogada(i, j, simbolo);
  }


  /**
   * @return       boolean
   * @param        i
   * @param        j
   */
  public boolean posicaoOcupada( int i, int j )
  {
	if (entidade.verificaPosicaoOcupada(i, j) == true)
			return true;
		else
			return false;
  }


  /**
   * @return       boolean
   */
  public boolean verificaTabuleiroCheio(  )
  {
	if (entidade.verificaTabuleiroOcupado() == true)
			return true;
		else
			return false;
	}
  }


}
