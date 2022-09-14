import java.util.ArrayList;

public class Economy extends Passagem{
    Economy(String cpf, String nome, String assento, Integer qtde,
            ArrayList<Double> pesos){
        
        super(cpf,nome,assento,qtde,pesos);
    }
    protected  Double custoBagagens(Integer qtde, ArrayList<Double> pesos){
        Double acumulador=super.custoBagagens(qtde, pesos);
        Double valorExtra = qtde*10.00;
        return acumulador*.5 + valorExtra;
    }
}