# API de carros

### Esse projeto possui uma documentação dinâmica feita em Swagger.
### Para acessar, acesse a URL
```http://localhost:8080/swagger-ui/index.html```

### Requisitos
- JDK
- MySQL

### Como rodar o projeto
#### Primeiramente é necessário criar o banco de dados, que está configurado para possuir o nome ``api``, porém caso deseje, pode ser trocado o nome através do arquivo ``application.properties`` dentro da pasta ``resources``.
#### Depois, é necessário abrir o projeto em seu editor de preferência (Eclipse, IntelliJ, VS Code) e iniciar a classe principal ``ApiApplication.java``.
#### As requisições do tipo ``GET`` podem ser testadas através do navagador, porém para testar a API em apenas um lugar, recomenda-se os softwares ``Postman`` e ``Insomnia``.

## Endpoints

## ``POST`` ``/api/cars``
### Realiza o cadastro de um carro

## ``GET`` ``/api/cars``
### Retorna uma lista com todos os carros
#### Esse endpoint possuí vários filtros e ordenações:

- Filtrar por marca
  
``/api/cars?brand=Renault``

- Filtrar por nome
  
``/api/cars?name=Duster``

- Filtrar por cor
  
``/api/cars?color=Verde``

- Filtrar por marca e nome
  
``/api/cars?brand=Renault&name=Duster``

- Filtrar por marca e cor
  
``/api/cars?brand=Renault&color=Verde``

- Filtrar por nome e cor
  
``/api/cars?name=Duster&color=Verde``

- Filtrar por marca, nome e cor
  
``/api/cars?brand=Renault&name=Duster&color=Verde``

- Ordenar por todos os parâmetros possíveis, 
  para isso deve-se indicar se é ascendente ou descendente
  
Os parâmetros possíveis são:
- chassi
- name
- brand
- color
- value
- yearManufacture

``/api/cars?sort=name,asc``
``/api/cars?sort=name,desc``
``/api/cars?sort=value,asc``
``/api/cars?sort=value,desc``
  
- Também é possível juntar a ordenação com a filtragem

``/api/cars?brand=Renault&name=Duster&color=Verde&sort=name,asc&sort=value,desc&sort=yearManufacture,desc``

- Além de todos esses filtros e ordenações, é possível filtrar o carro mais caro e o mais barato

 Filtrar carro mais caro

``/api/cars?mostExpensiveCar=mostExpensiveCar``

 Filtrar carro mais barato

``/api/cars?cheaperCar=cheaperCar``

## ``GET`` ``/api/cars/{id}``
### Retorna um único carro pelo ID

## ``DELETE`` ``/api/cars/{id}``
### Remove um carro pelo ID
