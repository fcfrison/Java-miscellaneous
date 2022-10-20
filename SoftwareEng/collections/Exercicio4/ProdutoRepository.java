package Exercicio4;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ProdutoRepository {
    public List<Produto> lista;
    ProdutoRepository(Integer MAX){
        lista = carregaDados(MAX);
    }
    public List<Produto> carregaDados(Integer MAX){
        Random rand = new Random(123456);
        List<Produto> linkedList = new LinkedList<Produto>();
        ListIterator<Produto> it = linkedList.listIterator();
        for(int i=0;i<MAX;i++){
            it.add(new Produto(i, "produto_"+i, 10*rand.nextDouble()));
        }
        return linkedList;
    }
    public Double calculaTotal(){
        return lista.stream()
                .map(x->x.getPreco())
                .reduce(0.0,(a,b)->a+b);
    }
    @Override
    public String toString() {
        return "ProdutoRepository [lista=" + lista + "\n]";
    }
    
}
