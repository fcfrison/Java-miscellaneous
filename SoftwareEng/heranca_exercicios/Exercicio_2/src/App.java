import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //Passagem 1
        ArrayList<Double> pesos_1 = new ArrayList<>();
        pesos_1.add(5.0);
        pesos_1.add(6.0);
        pesos_1.add(7.0);
        pesos_1.add(8.0);
        Passagem passagem1 = new Passagem("1234", "Michael", "15F",pesos_1.size(),
                                pesos_1);
        
        //Passagem 2
        ArrayList<Double> pesos_2 = new ArrayList<>();
        pesos_2.add(5.0);
        pesos_2.add(6.0);
        pesos_2.add(7.0);
        Economy passagem2 = new Economy("1234", "Michael", "15F",pesos_2.size(),
                                        pesos_2);
        //Passagem 3
        ArrayList<Double> pesos_3 = new ArrayList<>();
        pesos_3.add(5.0);
        pesos_3.add(6.0);
        Executive passagem3 = new Executive("1234", "Michael", "15F",pesos_3.size(),
                                            pesos_3);
        Premier passagem4 = new Premier("1234", "Michael", "15F",pesos_3.size(),
                                            pesos_3);
        System.out.println(passagem1);
        System.out.println(passagem2);
        System.out.println(passagem3);
        System.out.println(passagem4);
    }
}
