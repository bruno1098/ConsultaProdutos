# ConsultaProdutos
Visão Geral:
O projeto consiste em um sistema Cliente-Servidor em Java, onde o Cliente solicita informações de um Produto pelo ID para o Servidor. O Servidor responde com as informações sobre o Produto, obtidas a partir de um banco de dados Oracle. A interação entre Cliente e Servidor é realizada via Socket UDP, e as informações do Produto são exibidas no console do Cliente.

Estrutura do Projeto:
O projeto é organizado em três classes principais: Cliente, Servidor e Produto. Além disso, utiliza-se o framework Maven para gerenciamento de dependências e estruturação do projeto.

# Classes:

Cliente: Responsável por enviar a solicitação de informação sobre um Produto para o Servidor via Socket UDP. Após receber a resposta do Servidor, exibe as informações do Produto no console.
Servidor: Recebe a solicitação do Cliente via Socket UDP, processa a requisição consultando o banco de dados e responde ao Cliente com as informações do Produto solicitado.
Produto: Representa a estrutura de dados de um Produto, contendo os atributos: ID, nome, preço, validade, tamanho e descrição.
# Tecnologias Utilizadas:

Linguagem de Programação: Java
Gerenciamento de Projeto: Maven
Banco de Dados: Oracle
Protocolo de Comunicação: Socket UDP
Persistência de Dados: Hibernate e JPA

# Interação Cliente-Servidor:

O Cliente inicia a interação enviando uma solicitação de informações sobre um Produto para o Servidor via Socket UDP, informando o ID do Produto desejado.
O Servidor recebe a solicitação do Cliente e consulta o banco de dados Oracle para obter as informações do Produto com o ID fornecido.
Após obter as informações do Produto, o Servidor responde ao Cliente com os dados solicitados, utilizando o mesmo canal UDP.
O Cliente recebe a resposta do Servidor e exibe as informações do Produto no console.
Configuração do Ambiente:
O projeto utiliza o framework Maven para gerenciamento de dependências e estruturação do projeto. Além disso, é necessário configurar um banco de dados Oracle com uma tabela específica para armazenar as informações dos Produtos.

# Teste do Projeto:
Para testar o funcionamento do projeto:

Execute o Servidor.
Execute o Cliente e insira o ID do Produto desejado.
Verifique se as informações do Produto são exibidas corretamente no console do Cliente.

# Considerações Finais:
O projeto demonstra uma aplicação básica de interação Cliente-Servidor em Java, utilizando Socket UDP para comunicação, banco de dados Oracle para armazenamento e recuperação de informações dos Produtos, além de Hibernate e JPA para persistência de dados. Possui uma estrutura simples e modularizada, facilitando a compreensão e manutenção do código.
