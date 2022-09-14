import java.util.ArrayList;

public class Economy extends Passagem{
    Economy(String cpf, String nome, String assento, Integer qtde,
            ArrayList<Double> pesos){
        
        super(cpf,nome,assento,qtde,pesos);
    }
    protected  Double custoBagagens(Integer qtde, ArrayList<Double> pesos){
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
        Double valorExtra = qtde*10.00;
        return acumulador*.5 + valorExtra;
    }
}