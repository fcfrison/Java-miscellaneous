import java.util.Scanner;

import ClassesVeiculo.Placa;
import ClassesVeiculo.Veiculo;

public class mainExercicio1 {
    /**
     * 1.	Reescreva o método “main” de maneira que o mesmo receba pelos 
     * argumentos da linha de comando a placa do veículo, a quantidade de 
     * combustível que o mesmo deve ser abastecido e a distância que ele 
     * deve percorrer e imprima: os dados do veículo, a distância efetivamente 
     * percorrida (com o combustível disponível) e o combustível remanescente 
     * no tanque. Faça consistência sobre a quantidade e o tipo dos parâmetros 
     * informados exibindo uma mensagem adequada se for o caso.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Placa plate; 
        try{
            System.out.println("Type the vehicle plate: ");
            String vehiclePlate = sc.nextLine();
            plate = new Placa(vehiclePlate,"Brasil");
            System.out.println("Type the ammount of fuel to pump: ");
        Double fuelAmmount = Double.parseDouble(sc.nextLine());
        if(fuelAmmount<0){
            throw new RuntimeException("Fuel value can't be negative;");
        }
        Veiculo veiculo = new Veiculo(plate);
        veiculo.abastece(fuelAmmount);
        System.out.println(veiculo.getCombustivelNoTanque());

    }catch(Exception e){
        System.out.println(e.getMessage());
    }finally{
        sc.close();
    }
}
}

