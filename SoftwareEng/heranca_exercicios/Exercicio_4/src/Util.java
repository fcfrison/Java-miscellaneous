import java.util.Random;

public class Util {
    public static ContaBancaria geradorConta(Random rnd){
        Integer randomInteger = rnd.nextInt(10_000);
        switch(rnd.nextInt(3)){
            case 0: 
                return new ContaBancaria(
                        randomInteger, 
                        "correntista_"+randomInteger,
                        rnd.nextDouble()*1000
                        );
            case 1:
                return new ContaRemunerada(
                    randomInteger, 
                    "correntista_"+randomInteger,
                    rnd.nextDouble()*1000,
                    rnd.nextDouble()*100
                    );
            case 2:
                return new ContaComLimite(
                    randomInteger, 
                    "correntista_"+ randomInteger,
                    rnd.nextDouble()*1000,
                    rnd.nextDouble()*100,
                    rnd.nextDouble()*100
                    );
            default:
                return null;
        }
    }
}
