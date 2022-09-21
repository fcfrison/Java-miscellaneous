public class ContaBancaria {
    private Integer nrConta;
    private String nomeCorrentista;
    private Double saldo;
    public ContaBancaria(Integer nrConta,String nomeCorrentista, Double saldo){
        setNrConta(nrConta);
        setNomeCorrentista(nomeCorrentista);
        setSaldo(saldo);
    }
    public Integer getNrConta() {
        return nrConta;
    }
    public void setNrConta(Integer nrConta) {
        this.nrConta = nrConta;
    }
    public String getNomeCorrentista() {
        return nomeCorrentista;
    }
    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        if(saldo<0){
            throw new IllegalArgumentException("O valor do saldo inicial deve ser positivo.");
        }
        this.saldo = saldo;
    }
    public boolean deposito(Double valor){
        if(valor<0){
            return false;
        }
        this.setSaldo(this.getSaldo() + valor);
        return true;
    }
    public boolean retirada(Double valor){
        if(valor-getSaldo()<0){
            return false;
        }
        setSaldo(getSaldo()-valor);
        return true;
    }
}
