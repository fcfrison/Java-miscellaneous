public class ContaRemunerada extends ContaBancaria {
    Double perRem = 0.00;//percentual de remuneraçao por depósito.
    /**
     * Método que fixa o percentual da remuneração.
     * @param valor Um valor do tipo Double que estabelece a remuneracao por depósito.
     */
    public ContaRemunerada(Integer nrConta,String nomeCorrentista, 
                           Double saldo, Double percRemun){
        super(nrConta,nomeCorrentista,saldo);
        definePercentRemuneracao(percRemun);
    }
    /**
     * Método que seta o percentual de remuneração a ser pago por depósito realizado.
     * @param percRemun
     */
    void definePercentRemuneracao(Double percRemun){
        if(percRemun<0 || percRemun>100){
            throw new IllegalArgumentException("Valor deve estar entre 0 e 100.");
        }
        this.perRem = percRemun/100.0;
    }
    
    @Override
    public boolean deposito(Double valor){
        return super.deposito(valor*(1+perRem));
    }
}
