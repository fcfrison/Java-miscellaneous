package Exercicio4;

public class Produto {
    Integer codProduto;
    String descricao;
    Double preco;
    
    public Produto(Integer codProduto, String descricao, Double preco) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.preco = preco;
    }
    public Integer getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    @Override
    public String toString() {
        return "\nProduto [codProduto=" + codProduto + ", descricao=" + descricao 
                + ", preco=" + preco + "]";
    }
    
}
