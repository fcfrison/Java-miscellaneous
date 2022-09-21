public class ContaComLimite extends ContaBancaria{
    private final Double limiteDefault;
    private Double limite;
    private Double taxaJuros;
    private Double juros = 0.00;
    public ContaComLimite(Integer nrConta,String nomeCorrentista, Double saldo,
                          Double limite, Double taxaJuros){
        super(nrConta,nomeCorrentista,saldo);
        defineLimite(limite);
        this.limiteDefault = limite;
        defineTaxaJuros(taxaJuros);
    }

    public Double getJuros(){
        return this.juros;
    }

    /**
     * Método que define o limite para saque, se o saldo estiver zerado.
     * @param limite Um valor maior do que zero.
     * @return
     */
    public void defineLimite(Double limite){
        if(limite<0){
            throw new IllegalArgumentException("O limite para saque deve ser positivo.");
        }
        this.limite = limite;
    }
    /**
     * Método que define o valor da taxa de juros. 
     * @param taxaJuros Um valor entre 0 e 100.
     */
    public void defineTaxaJuros(Double taxaJuros){
        if(taxaJuros<0 || taxaJuros>100){
            throw new IllegalArgumentException("A taxa de juros deve ser um valor entre 0 e 100.");
        }
        this.taxaJuros = taxaJuros;
    }

    @Override
    public boolean retirada(Double valor){
        Double deltaSaldo = valor-getSaldo();
        if(deltaSaldo<0){//não há $ para cobrir o saque.
            return isRetiradaPossivel(deltaSaldo);
        }
        setSaldo(getSaldo()-valor);
        return true;
    }

    /**
     * Método que calcula os juros, dado um valor.
     * @param valor O valor sobre o qual se calcularão os juros;
     * @return Os juros devidos.
     */
    private Double calculaJuros(Double valor){
        return valor*taxaJuros;
    }

    /**
     * Método que verifica se o saque é possível. Se possível, o novo limite é 
     * atualizado e os juros devidos são setados. Se não possível, apenas retorna
     * false.
     * @param deltaSaldo A diferença entre o valor a ser sacado e o limite disponível.
     * @return true, se o saque foi possível. False, do contrário.
     */
    private boolean isRetiradaPossivel(Double deltaSaldo){
        Double excedente = limite+deltaSaldo;
        if(excedente<0){//Limite ultrapassado.
                return false;
            }
        limite = excedente;
        juros = calculaJuros(deltaSaldo);
        return true;
    }
    /**
     * Método que faz com que os juros devidos sejam pagos. Isso 
     * só será possível, se o saldo disponível for maior do que o valor
     * devido de juros. Além disso, o limite para saques é setado para o valor
     * default.
     * @return True, se os juros foram quitados. False, do contrário. 
     */
    public boolean quitaJuros(){
        if(getSaldo()>juros){
            this.retirada(juros);
            this.juros = 0.00;
            this.defineLimite(limiteDefault);
            return true;
        }
        return false;
    }   

}
