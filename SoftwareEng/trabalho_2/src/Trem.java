import java.util.ArrayList;

public class Trem {
    
    private Integer idTrem;
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;

    /**
     * @param idTrem O id do trem a ser inserido (não são aceitos ids repetidos)
     * @param locomotiva A primeira locomotiva do trem.
     * @param patioTrem A referência da memória que aponta p/o pátio do trem.
     */
    public Trem(Integer idTrem, Locomotiva locomotiva, PatioDosTrens patioTrem) { //Construtor da classe Trem.
        this.setIdTrem(idTrem, patioTrem);
        this.setVagoes(new ArrayList<Vagao>(100));
        this.setLocomotivas(locomotiva);
        patioTrem.addTrem(this); //Adicionando o trem recém criado na garagem.
    }

    public Integer getIdTrem() {
        return idTrem;
    }

    /**
     * Método que verifica se é possível inserir um novo id na lista de ids
     * já existentes.
     * @param idTrem Valor inteiro que identifica unicamente um trem.
     */
    public void setIdTrem(Integer idTrem,PatioDosTrens patioTrem) {
        if(patioTrem.getTrem(idTrem)!=null){
            throw new RuntimeException("Nao eh possivel inserir o trem no sistema."
                                            + " Id jah cadastrado. ");
        }
        this.idTrem = idTrem;
    }
    public ArrayList<Locomotiva> getLocomotivas(){
        return this.locomotivas;
    }

    private void setLocomotivas(Locomotiva locomotiva) {
        this.locomotivas = new ArrayList<Locomotiva>(50);
        this.engataLocomotiva(locomotiva);
    }

    public ArrayList<Vagao> getVagoes(){
        return this.vagoes;
    }
    private void setVagoes(ArrayList<Vagao> vagoes) {
        this.vagoes = vagoes;
    }
    
    /**
     * Método que retorna a quantidade de locomotivas ligadas ao trem.
     * @return Um inteiro referente à quantidade.
     */
    public Integer getQuantidadeLocomotivas(){
        return this.locomotivas.size();
    }

    /**
     * Método que retorna uma locomotiva, caso encontrada.
     * @param idLocomotiva O id da locomotiva buscada.
     * @return Uma instância da classe Locomotiva.
     */
    public Locomotiva getLocomotiva(Integer idLocomotiva){
        for (Locomotiva locomotiva : locomotivas) {
            if(locomotiva.getIdLocomotiva()==idLocomotiva){
                return locomotiva;
            }
        }
        return null;
    }

    /**
     * Método que retorna a quantidade de vagoes ligadas ao trem.
     * @return Um inteiro referente à quantidade.
     */
    public Integer getQuantidadeVagoes(){
        return this.vagoes.size();
    }

    /**
     * Método que retorna uma vagão, caso encontrado.
     * @param idVagao O id do vagão buscado.
     * @return Uma instância da classe Vagao.
     */
    public Vagao getVagao(Integer idVagao){
        for (Vagao vagao : vagoes) {
            if(vagao.getIdVagao()==idVagao){
                return vagao;
            }
        }
        return null;
    }    

    /**
     * Método que vincula uma locomotiva a um trem.
     * @param locomotiva Uma instância da classe Locomotiva.
     * @return true se e locomotiva foi inserida. 
     */
    public boolean engataLocomotiva(Locomotiva locomotiva){  
        if(!vagoes.isEmpty()){
            return false;
        } 
        if(locomotivas.add(locomotiva)){
            locomotiva.setTrem(this);
            locomotiva.getGarLoc().removeLocomotiva(locomotiva);//remove locomotiva da gar de loc.
            locomotiva.setGarLoc(null);
            return true;
        }
        return false;
    }

    private boolean verificaLimites(Vagao vagao, Double pesoVagoes){
        //Calculando os limites que não podem ser ultrapassados.
        Double limiteQtdeVagoes = locomotivas.get(0).getMaxVagoes() * 1.0;
        Double limiteQtdePeso = locomotivas.get(0).getPesoMaximo();
        
        for(int i=1;i<locomotivas.size();i++){
                limiteQtdePeso = limiteQtdePeso*0.9 + 
                                 locomotivas.get(i).getPesoMaximo(); 

                limiteQtdeVagoes = limiteQtdeVagoes+ 
                                  locomotivas.get(i).getMaxVagoes();
        }

        boolean pesoExcedido = pesoVagoes+vagao.getPesoMaximo()>limiteQtdePeso?
                                                true:false;

        boolean qtdeExcedida = vagoes.size()>=limiteQtdeVagoes?true:false;
        return pesoExcedido||qtdeExcedida;
    }

    private Double calculaPesoVagoes(){
        Double pesoVagoes=0.0; //Peso atual dos vagões.
        for (Vagao v : vagoes) {
            pesoVagoes+=v.getPesoMaximo();
        }
        return pesoVagoes;
    }
    /**
     * Método para inserir um vagao no ArrayList 'vagoes'.
     * @param vagao O vagao a ser inserido.
     * @return Um valor booleano (true se foi inserido; false, do contrário).
     */
    public boolean engataVagao(Vagao vagao){
        if(locomotivas.isEmpty()){
            return false;
        }        
        Double pesoVagoes = this.calculaPesoVagoes();
        boolean limiteExcedido = this.verificaLimites(vagao,pesoVagoes);
        if(limiteExcedido){
            return false;
        }
        vagoes.add(vagao);
        vagao.setTrem(this);
        vagao.getGarVag().removeVagao(vagao.getIdVagao());
        vagao.setGarVag(null);
        return true;
    }

    /**
     * Método que remove o vagão na última posição do trem.
     * @return Uma instância da classe Vagao.
     * A escolha por retornar um valor booleano se deu em razão do diagrama 
     * de classes presente no enunciado do execício.
     */
    public boolean desengataVagao(GaragemVagoes garagem){
        if(!vagoes.isEmpty()){//Se tiverem ainda vagoes a serem removidos.
            Vagao vagao= vagoes.remove(vagoes.size()-1);
            garagem.insereVagao(vagao);
            vagao.setTrem(null);
            vagao.setGarVag(garagem);
            return true;
        }
        return false;
    }


    /**
     * Método que público para remoção das locomotivas do trem.
     * @param garagem Uma referência de objeto da classe GaragemLocomotivas; 
     * @return Uma instância da classe Locomotiva.
     */
    public boolean desengataLocomotiva(GaragemLocomotivas garagem){
        return this.desengataLocomotiva(garagem,false); //O valor default para desfazTrem é false;
    }

    /**
     * Método privado para a remoção de locomotivas. Como a definição dos requisitos
     * estabelece que a primeira locomotiva do trem só poderá ser removida quando for 
     * se desfazer o trem, a flag 'desfazTrem' só estará acessível a métodos dentro 
     * da classe Trem. Ou seja, só será possível se remover a primeira locomotiva, 
     * se estiver se desfazendo o trem.
     * @param garagem Uma referência de objeto da classe GaragemLocomotivas;
     * @param desfazTrem Se true, então permite remover a primeira locomotiva; 
     * @return true, se a locomotiva foi desengata; false, do contrário.
     */
    private boolean desengataLocomotiva(GaragemLocomotivas garagem, boolean desfazTrem){
        boolean removeLoc = (desfazTrem == true) ? false : locomotivas.size()<=1;//Se desfazTrem é false, então só será
                                                                                //possível remover se locomotivas.size()>1. 
        if(!vagoes.isEmpty() || removeLoc ){//Primeiro, devem ser removidos todos os vagões. 
            return false;
        }
        Locomotiva locomotiva = locomotivas.remove(locomotivas.size()-1);
        locomotiva.setTrem(null);
        garagem.insereLoc(locomotiva); //Insere locomotiva na garagem.
        locomotiva.setGarLoc(garagem); //Insere a ref da garagem na locomotiva.
        return true;
    }

    /**
     * Método que remove o último elemento do trem;
     * @param garV A instância da garagem onde será armazenado o vagão.
     * @param garL A instância da garagem onde será armazenada a locomotiva.
     * @return True, se o elemento foi removido; false, do contrário.
     */
    public boolean removeUltimoElemento(GaragemVagoes garV, GaragemLocomotivas garL){
        boolean removido = desengataVagao(garV)==true ? true : //Tenta remover um vagão.
                           desengataLocomotiva(garL)==true ? true : //Tenta remover uma locomotiva;
                           false;
        return removido;
    }

    public void desfazerTrem(GaragemVagoes garV, GaragemLocomotivas garL, 
                            PatioDosTrens patTrem){
        for(int i=0;i<vagoes.size();i++){
            this.desengataVagao(garV);
        }
        for(int i=vagoes.size()-1;i>=0;i--){
            this.desengataVagao(garV);
        }
        
        for(int i=locomotivas.size()-1;i>=0;i--){
            this.desengataLocomotiva(garL,true);
        }
        patTrem.removeTrem(this.getIdTrem());

        //vagoes.forEach((arg)->desengataVagao(garV));
        //locomotivas.forEach((arg)->desengataLocomotiva(garL,true));
    }

    @Override
    public String toString() {
        return "Trem [idTrem=" + idTrem + "]";
    }

    
    
}
