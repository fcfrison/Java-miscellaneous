import java.util.ArrayList;

public class Executive extends Passagem {
    Executive(String cpf, String nome, String assento, Integer qtde,
            ArrayList<Double> pesos){
            super(cpf,nome,assento,qtde,pesos);        
    }

    @Override
    protected Double custoBagagens(Integer qtde, ArrayList<Double> pesos){
        Double acumulador=0.0;
        if(qtde<0){
            throw new IllegalArgumentException("A quantidade informada deve"+
                                                " ser um valor positivo");
        }
        if(qtde<=2){//duas bagagens são isentas de custo.
            return 0.00;
        }
        acumulador = super.custoBagagens(qtde, pesos);
        return acumulador;
    }

    Long getMilhas(){
        return Math.round(this.getCustoPassagem()*.1);
    }

}
