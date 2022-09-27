import java.util.ArrayList;

public class PatioDosTrens {
    private ArrayList<Trem> trens;  

    public PatioDosTrens(){
        this(100);
    }

    public PatioDosTrens(Integer capMax) {
        this.setTrens(capMax);
    }

    public ArrayList<Trem> getTrens(){
        return this.trens;
    }

    private void setTrens(Integer capMax){
        this.trens = new ArrayList<Trem>(capMax);
    }

    /**
     * Método que retorna o trem caso ele tenha sido encontrado na garagem.
     * @param idTrem Um valor inteiro referente ao id do trem.
     * @return Uma instância da classe Trem.
     */
    public Trem getTrem(Integer idTrem){
        for(Trem trem : trens){
            if(trem.getIdTrem()==idTrem){
                return trem;
            }
        }
        return null;
    }
    /**
     * Método que adiciona um trem na garagem de trens.
     * @param trem Uma instância da classe Trem.
     * @return Um valor booleano informando a respeito da inserção.
     */
    public boolean addTrem(Trem trem){
        return trens.add(trem);
        }
    
    /**
     * Método que retorna a quantidade de trens no pátio.
     * @return O valor de trens no pátio.
     */
    public Integer qtdeTrens(){
        return this.trens.size();
    }

    public boolean removeTrem(Integer idTrem){
        for (Trem trem : trens) {
            if(trem.getIdTrem()==idTrem){
                trens.remove(trem);
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "PatioDosTrens [trens=" + trens + "]";
    }

    
    
}
