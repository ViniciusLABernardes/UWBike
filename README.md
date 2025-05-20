# UWBike
## Sistema de Mapeamento de Motos nos Pátios da Mottu com ESP32 + UWB

# Integrantes:
 - Vinicius Leandro de Araujo Bernardes RM554728 TURMA 2TDSPY
 - Edvan Davi Murilo Santos do Nascimento RM554733 TURMA 2TDSPZ
- Rafael Romanini de Oliveira RM554637 TURMA 2TDSPZ


### O Sistema atualmente conta com:
#### - Gerenciamento de motos(cadastro/atualização/leitura de dados e remoção);
#### - Gerenciamento de pátios(cadastro/atualização/leitura de dados e remoção);
#### - Gerenciamento de motos no pátio(cadastro/atualização/leitura de dados);
#### - Gerenciamento de âncoras do pátio(cadastro/atualização/leitura de dados e remoção)

## 💡 Objetivo
Desenvolver uma aplicação que:
- Comunique-se com ESP32 via rede/local.
- Receba coordenadas precisas de localização.
- Mapeie em tempo real a posição das motos nos pátios.

## ⚙️ Etapas para rodar o projeto:

## Entidades do projeto:
- ### Moto
- - idMoto
  - modelo
  - placa
  - chassi
  - posicaoX   (Ambas as posições são atributos Transient, pois só serão armazenadas em memória na hora que a função calcularPosicaoMoto for acionada)
  - posicaoY
    
- ### Patio
- - idPatio
  - logradouro
  - numero
  - complemento
  - cep
  - cidade
  - uf
  - pais
  - lotacao
    
- ### MotoPatio
##### OBS** Esta entidade foi criada pois queriamos uma tabela associativa que tivesse outros campos alem dos ids de cada tabela que serão associadas **
- - moto
  - patio
  - dataHoraEntrada
  - dataHoraSaida
 
- ### Ancora
- - id
  - x
  - y


## Requisições da parte de gerenciamento de moto:

### Cadastrar moto:

 
![cadastroMoto](https://github.com/user-attachments/assets/ad0dd6b7-3109-4d77-bf3f-be2d63fddb9f)

### Visualizar moto especificada por id:

![lerMoto](https://github.com/user-attachments/assets/95e47008-4385-4596-9699-3c8a0fce4123)

### Atualizar placa da moto:
![attMoto](https://github.com/user-attachments/assets/d6b30265-65a6-4c23-b431-4f34184635d4)

