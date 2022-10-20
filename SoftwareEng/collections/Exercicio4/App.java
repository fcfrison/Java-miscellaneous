package Exercicio4;

public class App {
    public static void main(String[] args) {
        final Integer MAX = 10;
        ProdutoRepository lista = new ProdutoRepository(MAX);
        lista.carregaDados(MAX);
        System.out.println(lista);
        System.out.println(lista.calculaTotal());
    }
    
}
