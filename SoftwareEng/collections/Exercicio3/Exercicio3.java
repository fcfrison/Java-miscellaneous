package Exercicio3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

public class Exercicio3{
    public static void main(String[] args) {
        Integer MAX = 20;
        List<Integer> lista = new ArrayList<Integer>();
        ListIterator<Integer> it = lista.listIterator();
        Random rand = new Random(1000);
        for(int i=0;i<MAX;i++){
            it.add(rand.nextInt(5));
        }
        System.out.println(lista);
        List<Integer> listaSemRep = retornaSet(lista);
        System.out.println(listaSemRep);

    }
    public static List<Integer> retornaSet(List<Integer> lista){
        Set<Integer> set = new HashSet<Integer>(lista);
        return new LinkedList<Integer>(set);
    }
}