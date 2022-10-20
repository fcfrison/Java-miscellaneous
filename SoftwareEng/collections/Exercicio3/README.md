## Descrição
(*)Em um evento interno de uma empresa o controle de acesso não foi bem planejado. 
Na entrada da sala foi colocado um leitor de código barras capazes de ler o 
código de barras do crachá dos funcionários. O sistema acoplado ao leitor era capaz 
de identificar o número de matrícula do funcionário (Integer) e gravá-lo em um 
arquivo texto. Como os funcionários não foram bem orientados, ao longo do dia 
vários terminaram passando o crachá mais de uma vez gerando uma lista com números 
repetidos. Escreva um método Java que recebe como parâmetro uma “List<Integer>” 
contendo todos os números de matrícula registrados pelo leitor e devolve outra 
“List<Integer>” com os números de matrícula sem repetição