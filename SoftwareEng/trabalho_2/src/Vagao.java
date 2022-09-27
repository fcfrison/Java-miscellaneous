public class Vagao {
    private static Integer idControle = 0;
    private Integer idVagao;
    private Double pesoMaximo;
    private Trem trem = null;
    private GaragemVagoes garVag = null;
    /**
     * @param pesoMaximo O peso máximo suportado pelo vagão.
     * @param garVag A referência de memória da garagem em q/ficará o vagão.
     */
    public Vagao(Double pesoMaximo, GaragemVagoes garVag) {
        this.setIdVagao(idControle++);//id de auto-incremento
        this.setPesoMaximo(pesoMaximo);
        this.setGarVag(garVag);
    }

    public Integer getIdVagao() {
        return idVagao;
    }

    private void setIdVagao(Integer idVagao) {
        this.idVagao = idVagao;
    }

    public Double getPesoMaximo() {
        return pesoMaximo;
    }

    private void setPesoMaximo(Double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    public Trem getTrem(){
        return this.trem;
    }

    public void setTrem(Trem trem) {
        this.trem = trem;
    }

    
    public GaragemVagoes getGarVag() {
        return garVag;
    }

    public void setGarVag(GaragemVagoes garVag) {
        this.garVag = garVag;
    }

    @Override
    public String toString() {
        return "Vagao [idVagao=" + idVagao + ", pesoMaximo=" 
                + pesoMaximo + "]";
    }   
}
