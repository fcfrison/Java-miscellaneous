import java.util.Scanner;

public class Utils {
/**
 * A classe Utils foi criada para disponibilizar funções que realizam tarefas
 * não finalísticas (como limpar a tela do terminal do usuário).
 */    

     /**
     * Método de classe que faz com que, após algo ter sido impresso na tela,
     * o usuário deva pressionar 'Enter' para "prosseguir".
     */
    private static void pressioneEnter(){
        System.out.println("\nPressione enter para continuar.");
        try{
            System.in.read();
        }catch(Exception e){}
    }

    /**Método responsável por limpar a tela do terminal. */
    private static void limpaTela(){
        System.out.print("\033[H\033[2J");
    }

    /**
     * Método que limpa a tela e aguarda a tecla Enter ser pressionada.
     * @param sc Uma instância da classe Scanner.
      */
    public static void limpaPressionaEnter(Scanner sc){
        Utils.pressioneEnter();
        sc.nextLine();
        Utils.limpaTela();
    }
}

