# Serviços REST

1) Arquitetura
Foi utilizado o framework Spring, mais especificamente, o projeto Spring Boot pela facilidade de configurar a aplicação, o que agiliza o desenvolvimento. Além disso, o Spring Boot conta com um container embarcado (por default é o Tomcat), não sendo necessário configurar um servidor a parte, outra facilidade.

Quanto ao banco de dados, foi escolhido o MySQL por fornecer o recurso de integridade referencial.

2) Execução do projeto
Para executar o projeto:
mvn spring-boot:run
Ou em "Maven build...", incluir no campo Goal spring-boot:run e executá-lo.

3) Exemplos de chamadas via cURL

3.1) Incluir um ou mais itens

Exemplo com um item apenas:
curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '[{"ativo": 1, "caixaPadrao" : 60, "codigo" : "123", "ean" : "456", "ncm" : "789", "nomenclatura" : "Paracetamol", "sal" : "um"}]' http://localhost:8080/produto/insere

Exemplo com mais de um item:
curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '[{"ativo": 1, "caixaPadrao" : 60, "codigo" : "123", "ean" : "456", "ncm" : "789", "nomenclatura" : "Paracetamol", "sal" : ""},
{"ativo": 1, "caixaPadrao" : 60, "codigo" : "678", "ean" : "243", "ncm" : "905", "nomenclatura" : "Epocler", "sal" : ""}]' http://localhost:8080/produto/insere

3.2) Alterar preço de um ou mais itens

Exemplo com um item apenas:
curl -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '[{"produtoId": 1,  "preco" : 4.20}]' http://localhost:8080/produto/alterarPreco

Exemplo com mais de um item:
curl -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '[{"produtoId": 1,  "preco" : 5.80}, {"produtoId": 2,  "preco" : 9.99}]' http://localhost:8080/produto/alterarPreco

3.3) Pesquisar por todos os itens
curl http://localhost:8080/produto/listar