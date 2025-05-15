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

## 💡 Objetivo
Desenvolver uma aplicação que:
- Comunique-se com ESP32 via rede/local.
- Receba coordenadas precisas de localização.
- Mapeie em tempo real a posição das motos nos pátios.

## ⚙️ Etapas para rodar o projeto:

## Entidades do projeto:
- Moto
- - idMoto
  - modelo
  - placa
  - chassi
    
- Patio
- - idPatio
  - logradouro
  - numero
  - complemento
  - cep
  - cidade
  - uf
  - pais
  - lotacao
    
- MotoPatio
- - moto
  - patio
  - dataHoraEntrada
  - dataHoraSaida
