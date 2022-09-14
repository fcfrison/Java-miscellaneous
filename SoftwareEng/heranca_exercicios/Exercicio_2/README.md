## Descrição do exercício
A classe Passagem que segue modela a estrutura básica de uma passagem de avião de uma determinada companhia aérea. Conforme a categoria da passagem os custos de bagagem e aquisição de assentos podem variar. Além disso, algumas categorias têm direito a milhas e outras não. Na classe “Passagem”, o método “custoBagagem” recebe por parâmetro a quantidade de bagagens a serem despachadas e um arranjo contendo o peso de cada uma delas. Já o método “defineAssento” recebe por parâmetro o identificador do assento (ex: “15F”) e retorna o custo para reservar este assento. O custo básico das bagagens é de R$ 0,50 por Kg e o custo da marcação de assentos de R$ 5,00 por assento.

![Class diagram](class_diagram.png "Class diagram")

- Na categoria Economy, além do custo normal das bagagens, é cobrado um adicional de R$10,00 por bagagem.
- Na categoria Executive duas bagagens são isentas de custo e a viagem dá direito a 10% do custo da passagem em milhas;
- Na Premier a marcação de assento não tem custo, as bagagens recebem um desconto de 50% em relação a categoria Executiva e o cliente recebe 20% do custo da passagem em milhas;
