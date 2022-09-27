import java.util.ArrayList;

public class GaragemLocomotivas {
    private ArrayList<Locomotiva> locomotivas;

    public GaragemLocomotivas(){
        this(250);
    }

    public GaragemLocomotivas(int capacidade){
        this.locomotivas = new ArrayList<Locomotiva>(capacidade);
    }
    public ArrayList<Locomotiva> getLocomotivas(){
        return this.locomotivas;
    }
    public Locomotiva getLocomotiva(Integer idLocomotiva){
        for (Locomotiva locomotiva : locomotivas) {
            if(locomotiva.getIdLocomotiva()==idLocomotiva){
                return locomotiva;
            }
        }
        return null;
    }

    /**
     * Método para remover locomotivas. 
     * @param locomotiva Uma instância da classe Locomotiva.
     * @return True, se foi possível remover; false, do contrário.
     */
    public boolean removeLocomotiva(Locomotiva locomotiva){
        return locomotivas.remove(locomotiva);
    }

    /**
     * Método para inserir locomotivas na garagem.
     * @param locomotiva Uma instância da classe Locomotiva
     * @return Um valor boleando (true para inserção; false, do contrário)
     */
    public boolean insereLoc(Locomotiva locomotiva){
        return locomotivas.add(locomotiva);
    }

    @Override
    public String toString() {
        return "GaragemLocomotivas [locomotivas=" + locomotivas + "]";
    }

}
