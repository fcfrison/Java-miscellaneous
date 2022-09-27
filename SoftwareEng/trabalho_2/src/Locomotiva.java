
public class Locomotiva {
    private static Integer idControle = 0;
    private Integer idLocomotiva;
    private Double pesoMaximo;
    private Integer maxVagoes;
    private Trem trem = null;
    private GaragemLocomotivas garLoc = null;

    public Locomotiva(Double pesoMaximo,Integer maxVagoes, GaragemLocomotivas gLoc) {
        this.setIdLocomotiva(idControle++);//id de auto-incremento
        this.setMaxVagoes(maxVagoes);
        this.setPesoMaximo(pesoMaximo);
        this.setGarLoc(gLoc);

    }
    public Integer getIdLocomotiva() {
        return idLocomotiva;
    }
    private void setIdLocomotiva(Integer idLocomotiva) {
        this.idLocomotiva = idLocomotiva;
    }
    public Integer getMaxVagoes() {
        return maxVagoes;
    }
    private void setMaxVagoes(Integer maxVagoes) {
        this.maxVagoes = maxVagoes;
    }
    public Double getPesoMaximo() {
        return pesoMaximo;
    }
    private void setPesoMaximo(Double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    
    public void setTrem(Trem trem){
        this.trem = trem;
    }

    public void setGarLoc(GaragemLocomotivas garLoc){
        this.garLoc = garLoc;
    }
    
    public GaragemLocomotivas getGarLoc(){
        return this.garLoc;
    }

    @Override
    public String toString() {
        return "Locomotiva [idLocomotiva=" + idLocomotiva + ", maxVagoes=" +
                maxVagoes + ", pesoMaximo=" + String.format("%.2f",pesoMaximo) 
                + ", trem=" + trem + "]";
    }
    
    
}
