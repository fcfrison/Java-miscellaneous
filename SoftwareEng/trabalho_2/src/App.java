import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        int qtdInicialVagoes = 10; //Qtde de vagoes
        int qtdIniLoc = 5;        //Qtde de locomotivas
        Scanner sc = new Scanner(System.in);
        String pick, pickEdicao; //Variáveis auxiliares
        Integer id; //Variável auxiliar para armazenar ids
        Locomotiva locomotiva; //Variável auxiliar para locomotivas.
        Vagao vagao; //Variável auxiliar para vagões.
        Trem trem; //Variável auxiliar para trens.
        
        //Criando o pátio dos trens
        PatioDosTrens patTrem = new PatioDosTrens(50);

        //Gerando vagões e inserindo na garagem de vagões.
        GaragemVagoes gVag = new GaragemVagoes();
        App.geraVagoes(gVag, qtdInicialVagoes);
        

        //Gerando locomotivas e inserindo na garagem de locomotivas.
        GaragemLocomotivas gLoc = new GaragemLocomotivas();
        App.geraLocomotivas(gLoc, qtdIniLoc);

        do{
            System.out.print(
                """
                Selecione a opcao desejada:
                1. Cadastrar trem
                2. Editar o trem
                3. Listar todos os trens jah criados
                4. Desfazer um trem
                5. Sair do menu
                """);
            pick = sc.nextLine();
            switch(pick){
                case "1":
                    System.out.println("Digite o id do trem: ");
                    try {
                        id = Integer.parseInt(sc.nextLine());
                        System.out.println("Digite o id da locomotiva: "); 
                        locomotiva = gLoc.getLocomotiva( 
                                            Integer.parseInt(sc.nextLine()));
                        
                        if(locomotiva==null){
                            System.out.println("Id da locomotiva não encontrado."); 
                            break;
                        }
                            new Trem(id,locomotiva,patTrem);//Cria e insere trem no pátio.
                            System.out.println("O trem foi criado e inserido no patio.");
                        }catch(NumberFormatException ex){
                            System.out.println("O valor digitado eh invalido.");
                        }catch(RuntimeException ex){
                            System.out.println(ex.getMessage());
                        }finally{
                            Utils.limpaPressionaEnter(sc);
                        }
                    break;
                case "2":
                        try{
                            System.out.println("Digite o id do trem a ser editado:");
                            id = Integer.parseInt(sc.nextLine());
                            trem = patTrem.getTrem(id);
                            if(trem==null){
                                System.out.println("Trem não encontrado.");
                                break;
                            }
                            do{
                                pickEdicao =App.escolheOpcoesEdicao(sc);
                                switch(pickEdicao){
                                    case "1":
                                        System.out.println("Digite o id da locomotiva a ser inserida: ");
                                        locomotiva = gLoc.getLocomotiva(Integer.
                                                        parseInt(sc.nextLine()));
                                        if(locomotiva==null) {
                                            System.out.println("Locomotiva nao encontrada.");
                                            Utils.limpaPressionaEnter(sc);
                                            break;
                                        }
                                        trem.engataLocomotiva(locomotiva);
                                        System.out.println("Locomotiva engatada");
                                        Utils.limpaPressionaEnter(sc);
                                        break;
                                    case "2":
                                        System.out.println("Digite o id do vagao a ser inserido");
                                        vagao = gVag.removeVagao(Integer.
                                                     parseInt(sc.nextLine()));
                                        if(vagao==null){
                                            System.out.println("Vagao nao encontrado");
                                            Utils.limpaPressionaEnter(sc);
                                            break;
                                        }
                                        boolean isEngatado = trem.engataVagao(vagao);
                                        if(!isEngatado) {
                                            System.out.println("Vagao nao engatado.");
                                            gVag.insereVagao(vagao);
                                        }else System.out.println("Vagao engatado."); 
                                        Utils.limpaPressionaEnter(sc);
                                        break;
                                    case "3":
                                        boolean foiRemovido = trem.removeUltimoElemento(gVag, gLoc);
                                        if(foiRemovido) System.out.println("Elemento removido");
                                        else System.out.println("Ultimo elemento nao removido");
                                        Utils.limpaPressionaEnter(sc);
                                        break;
                                    case "4":
                                        gLoc.getLocomotivas().forEach(System.out::println);
                                        Utils.limpaPressionaEnter(sc);
                                        break;
                                    case "5":
                                        gVag.getVagoes().forEach(System.out::println);
                                        Utils.limpaPressionaEnter(sc);
                                        break;
                                    case "6":
                                        trem.getVagoes().forEach(System.out::println);
                                        Utils.limpaPressionaEnter(sc);
                                        break;
                                    case "7":
                                        trem.getLocomotivas().forEach(System.out::println);
                                        Utils.limpaPressionaEnter(sc);
                                        break;
                                    case "8":
                                        break;
                                    default:
                                        System.out.println("Opcao invalida");
                                } 

                            }while(!pickEdicao.equals("8"));
                             
                        }catch(NumberFormatException ex){
                            System.out.println("ERRO: " + ex.toString());
                            Utils.limpaPressionaEnter(sc);
                        }
                        break;
                case "3":
                        if(patTrem.qtdeTrens()>0){
                            System.out.println(patTrem);
                            Utils.limpaPressionaEnter(sc);
                        }else{
                            System.out.println("Nao ha trens no patio.");
                        }
                        break;
                case "4":
                        System.out.println("Informe o id do trem a ser desfeito: ");
                        try {
                            trem = patTrem.getTrem(Integer.parseInt(
                                                        sc.nextLine()));
                            if(trem==null){
                                System.out.println("Trem nao encontrado.");
                                Utils.limpaPressionaEnter(sc);
                                break;
                            }
                            trem.desfazerTrem(gVag, gLoc, patTrem);
                            System.out.println("Trem desfeito.");
                            Utils.limpaPressionaEnter(sc);
                        }catch(NumberFormatException ex){
                            System.out.println("O valor digitado eh invalido.");
                            Utils.limpaPressionaEnter(sc);
                        }
                        break;
                case "5":
                        break;
                default:
                    Utils.limpaPressionaEnter(sc);
            }
        }while(!pick.equals("5"));
        sc.close();
        System.out.println("Voce saiu do menu.");
    }

    /**
     * Método que imprime as opcoes de edição do trem.
     * @param sc Instância da classe Scanner.
     * @return Uma instância da classe String com a opcao escolhida.
     */
    public static String escolheOpcoesEdicao(Scanner sc){
        System.out.print(
            """
            Escolha a opcao:
                1. Inserir uma locomotiva (informar identificador);
                2. Inserir um vagao (informar identificador);
                3. Remover o último elemento do trem;
                4. Listar locomotivas livres;
                5. Listar vagoes livres;
                6. Listar os vagoes associados ao trem;
                7. Listar as locomotivas associadas ao trem;
                8. Encerrar a edicao do trem;
            """
        );
        return sc.nextLine();
    }

    /**
     * Método para auxiliar na criação de locomotivas.
     * @param gLoc Uma instância de uma garagem de locomotivas. 
     * @param qtdIniLoc A quantidade de locomotivas a ser criada.
     */
    public static void geraLocomotivas(GaragemLocomotivas gLoc, int qtdIniLoc){
        Random rand = new Random(22180008);
        for(int i=0;i<qtdIniLoc;i++){
            gLoc.insereLoc(new Locomotiva(rand.nextDouble()*2_000, 
                           rand.nextInt(5)+1,
                           gLoc));
        }
    }

    /**
     * Método para auxiliar na criação de vagões. 
     * @param gVag Uma instância de uma garagem de vagões. 
     * @param qtdInicialVagoes A quantidade de vagões a serem criados.
     */
    public static void geraVagoes(GaragemVagoes gVag, int qtdInicialVagoes){
        Random rand = new Random(22180008);
        for(int i=0;i<qtdInicialVagoes;i++){
            gVag.insereVagao(new Vagao(rand.nextDouble()*1000,gVag));
        }
    }
}
