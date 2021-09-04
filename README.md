# Microsercvices_Architeture
### Comunicação entre microservices utilizando ServerClient, Eureka, Gateway  
  O projeto consiste em aplicações microservices onde foi desenvolvido uma aplicação para cadastro de clientes e a segunda aplicação  
  foi desenvolvida para cadastro de endereços, as estruturas são simples apenas com crud para simular a comunicação entre essas aplicações atraves  
  de outros microservices, as configurações destas aplicações foram armazenadas em um repositorio remoto (https://github.com/guilhermefasilva/springCloundConfig.git)
  onde é feito uma configuração apontando para o microservice ConfigServer e este fica aresponsável por acessar o repositorio remoto contendo as configurações.
  O microservice ServiceDiscovery faz o papel de registro de aplicações onde cada uma por si informa sua disponibilidade sendo registrada no ServiceDiscovery.
  O Gateway fica responsável pela visibilidade das aplicações onde informando o endereço http descrito nas configurações será direcionado para o microservice  
  solicitado.  
  
#### Tecnologias Utilizadas  

* SpringBoot
* Eureka  
* Config Server (Spring Cloud)  
* Gateway (Spring Cloud)  
* Service Discovery (Spring Cloud)  
* IDE Eclipse  
* Banco de dados H2 e MYsql  
* ModelMapper 
* JPA
* Lombok

#### Acesso nas aplicações  
* Microservice_Address_Catalog: http://localhost:8082  
* Microservice_Client: http://localhost:8081  
* Gateway: http://localhost:8080  
* Config_Server: http://localhost:8083  
* Service_Discovery: http://localhost:9000  

#### Sites Referenciais  
 <a href= "https://mvnrepository.com/"> Dependencias Maven </a>  
 <a href= "https://projectlombok.org/"> Lombok </a>  
 <a href= "http://modelmapper.org/"> ModelMapper Documentation  </a>  
 <a href= "https://www.eclipse.org/downloads/"> Eclipse </a>  
 <a href= "https://start.spring.io/"> Spring initializr </a>  
 <a href= "https://github.com/"> GitHub </a>  
 <a href= "https://git-scm.com/"> Git </a>  
