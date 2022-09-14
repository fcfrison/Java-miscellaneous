import java.util.ArrayList;

public class Passagem {
    protected String cpf;
    protected String nome;
    protected String assento;
    protected Double custoPassagem;

    
    public Passagem(String cpf, String nome, String assento, Integer qtde,
                    ArrayList<Double> pesos) {
        this.cpf = cpf;
        this.nome = nome;
        this.assento = assento;
        this.setCustoPassagem(qtde,pesos);
        

    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAssento() {
        return assento;
    }
    public void setAssento(String assento) {
        this.assento = assento;
    }
    public Double getCustoPassagem() {
        return custoPassagem;
    }
    public void setCustoPassagem(Integer qtde,ArrayList<Double> pesos){
        this.custoPassagem = this.custoBagagens(qtde, pesos) + 
                             this.defineAssento(this.getAssento());
    }
    protected Double custoBagagens(Integer qtde, ArrayList<Double> pesos){
        if(pesos.size()!=qtde){
            throw new IllegalArgumentException("A quantidade de pesos de" +
                                    "bagagens informadas é diferente da " +
                                    "quantidade informada"); 
        }
        if(qtde<0){
            throw new IllegalArgumentException("A quantidade informada deve"+
                                                " ser um valor positivo");
        }
        Double acumulador=0.0;
        for (Double peso : pesos) {
            if(peso<0){
                throw new IllegalArgumentException("Nao sao aceitos pesos negativos.");
            }
            acumulador+=peso;
        }
        return acumulador*.5;
    }
    Double defineAssento(String assento){
        return 5.00;
    }
    
}
