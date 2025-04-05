# Projeto de Coleta de Dados de Sensores com Arduino e Spring Boot

Este projeto é uma aplicação Java desenvolvida com Spring Boot que realiza a leitura de dados de sensores conectados a um Arduino. Os dados coletados incluem informações de umidade, temperatura e luminosidade, que são processadas e disponibilizadas através de uma API RESTful.

## Funcionalidades

- *Leitura de Sensores*: Coleta de dados de sensores de umidade, temperatura e luminosidade conectados ao Arduino.
- *API RESTful*: Endpoints para acessar os dados coletados dos sensores.
- *Conversão de Dados*: Processamento e conversão dos dados recebidos para objetos Java.
- *Resposta Padronizada*: Utilização de uma estrutura de resposta consistente para as requisições.

## Estrutura do Projeto

O projeto segue a seguinte estrutura de pacotes:

- com.arduino.app: Pacote principal contendo a classe de inicialização da aplicação.
- com.arduino.app.entities: Contém as classes que representam as entidades do domínio, como os sensores e a estrutura de resposta.
- com.arduino.app.controllers: Define os controladores que expõem os endpoints da API.
- com.arduino.app.service: Contém as classes responsáveis pela lógica de negócio, incluindo a leitura dos dados dos sensores e a criação das entidades correspondentes.

## Dependências Principais

- *Spring Boot Starter Web*: Facilita a criação da API RESTful.
- *jSerialComm*: Biblioteca para comunicação serial com o Arduino.
- *Gson*: Utilizada para a conversão de objetos Java para JSON e vice-versa.
- *Apache POI*: Biblioteca para manipulação de arquivos do Microsoft Office (embora não esteja sendo utilizada no código fornecido).

## Configuração e Execução

1. *Configuração do Arduino*: Certifique-se de que o Arduino está programado para enviar os dados dos sensores no formato JSON esperado pela aplicação.

2. *Configuração das Portas Seriais*: Atualize as constantes PORT_HUMIDITY_SENSOR, PORT_LIGHT_SENSOR e PORT_TEMPERATURE_SENSOR na classe SerialReaderService com os nomes das portas seriais correspondentes aos sensores no seu sistema.

3. *Execução da Aplicação*: Com o ambiente configurado, execute a aplicação Spring Boot. Os endpoints estarão disponíveis em http://localhost:8080/api.

## Endpoints Disponíveis

- GET /api/umidade: Retorna os dados do sensor de umidade.
- GET /api/temperatura: Retorna os dados do sensor de temperatura.
- GET /api/luminosidade: Retorna os dados do sensor de luminosidade.

## Observações

- *Modo de Teste*: A variável test na classe SerialReaderService está definida como true para simular dados dos sensores. Para conectar-se a um Arduino real, altere essa variável para false.

- *Tratamento de Exceções*: A aplicação inclui tratamento básico de exceções para falhas na comunicação serial e processamento de dados.
