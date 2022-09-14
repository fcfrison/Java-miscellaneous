import java.util.ArrayList;

public class Premier extends Executive {
    Premier(String cpf, String nome, String assento, Integer qtde,
            ArrayList<Double> pesos){
        super(cpf,nome,assento,qtde,pesos);  
    } 
    @Override
    public void setCustoPassagem(Integer qtde,ArrayList<Double> pesos){
        this.custoPassagem = (this.custoBagagens(qtde, pesos) + 
                             this.defineAssento(this.getAssento()))*.5;
    }
    @Override
    Long getMilhas(){
        return Math.round(this.getCustoPassagem()*.2);
    }
}
