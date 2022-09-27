import java.util.ArrayList;

public class GaragemVagoes {
    private ArrayList<Vagao> vagoes;
    
    public GaragemVagoes(){
        this(500);
    }
    public GaragemVagoes(Integer capacidade){
        this.vagoes = new ArrayList<Vagao>(capacidade);
    }
    public ArrayList<Vagao> getVagoes(){
        return this.vagoes;
    }

    
    /**
     * Método para remover vagões.
     * @param idVagao O id do vagão a ser removido
     * @return Uma instância da classe Vagao
     */
    public Vagao removeVagao(Integer idVagao){
        for(int i=0;i<vagoes.size();i++){
            if(idVagao==vagoes.get(i).getIdVagao()){
                return vagoes.remove(i);
            }
        }
        return null;
    }

    /**
     * Método para inserir vagões na garagem.
     * @param vagao Uma instância da classe Vagao
     * @return Um valor boleando (true para inserção; false, do contrário)
     */
    public boolean insereVagao(Vagao vagao){
        return vagoes.add(vagao);
    }
    @Override
    public String toString() {
        return "GaragemVagoes [vagoes=" + vagoes + "]";
    }

    
}
