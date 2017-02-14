# Delivery Management #
Módulo responsável por fazer a gestão das malhas logísticas, dando suporte para a gestão das entregas

# Instruções de Execução #
 - Download do jar do banco HSQLDB (Versão 2.3.4)
   https://sourceforge.net/projects/hsqldb/files/latest/download?source=files
   Descompactar o arquivo e acessar via terminal a pasta lib

 - Iniciar o server do HSQLDB
   java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 delivery-management

 - Acessar a pasta do projeto e executar:
   mvn -DskipTests package

 - Após a geração do build com sucesso a aplição poderá ser iniciada
   Ex: mvn spring-boot:run

 Obs: Como o hsqldb é um banco em memória, os scripts iniciais serão executados no start da aplicação.

# Swagger #
Documentação das APIs
localhost:8080/swagger-ui.html

# Exemplos #
POST Malha Logística
{
  "malhaLogistica": {
    "distancia": 0,
    "nome": "string",
    "pontoFinal": "string",
    "pontoInicial": "string"
  }


GET Malha Logística

[
  {
    "distancia": 0,
    "nome": "string",
    "pontoFinal": "string",
    "pontoInicial": "string"
  }
]


# Bibliotecas Utilizadas #
 - Spring Boot: Projeto Spring, criado para facilitar o start inicial de um projeto, efetuando automaticamente algumas configurações
 - Spring MVC: Projeto Spring, facilita na utilização do modelo MVC. É amplamente utilizado pela comunidade, e facilita o desenvolvimento, tornando o código mais limpo e facil de ser mantido. É intuitívo, pois boa parte dos comportamentos são configurados utilizando annotations.
 - Spring Data JPA: Facilita algumas operações de persistência de dados, ou CRUD. É uma abstração das ferramentas ORM. Utilizei, pois facilita e muito as operações com o Banco de dados. Query Metho ajuda bastante.
 - HSQLDB: Banco de dados em memória. Utilizei pois, não existe necessidade de instalação, apenas execução de arquivo jar
 - Swagger: É definido como um framework. É útil para documentar e até mesmo testar suas APIs  

