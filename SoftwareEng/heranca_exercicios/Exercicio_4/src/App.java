import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Integer NRCONTAS = 10;
        ArrayList<ContaBancaria> contasBancarias = new ArrayList<>(20);
        Random rand = new Random(1561);
        for(int i=0;i<NRCONTAS;i++){
            contasBancarias.add(Util.geradorConta(rand));
        }
        System.out.println(contasBancarias);

    }
}
