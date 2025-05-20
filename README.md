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
### 1 - Instale o JDK 21
### 2 - Teste as requisições pelo postman/navegador/etc assim como foram feitas nos prints demonstrativos


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
 #### OBS ** Esta entidade representa os receptores de sinal uwb do esp32 que ficarão instalado nos pátios
- - id
  - x
  - y


## Requisições da parte de gerenciamento de moto:

### Cadastrar moto:

![cadastroMoto](https://github.com/user-attachments/assets/ad0dd6b7-3109-4d77-bf3f-be2d63fddb9f)

### Visualizar moto especifica por id:

![lerMoto](https://github.com/user-attachments/assets/95e47008-4385-4596-9699-3c8a0fce4123)

### Atualizar placa da moto:
![attMoto](https://github.com/user-attachments/assets/d6b30265-65a6-4c23-b431-4f34184635d4)

### Deletar moto:
![delMoto](https://github.com/user-attachments/assets/e295782c-0746-4eee-bca2-3662a3c97029)


## Requisições da parte de gerenciamento de pátio:

### Cadastrar pátio:

![cadastroPatio](https://github.com/user-attachments/assets/bead9041-a6b1-4772-8304-3bfcb805e26d)

### Visualizar pátio especifico por id:

![lerPastioEsp](https://github.com/user-attachments/assets/8e657fdd-5097-4d8d-ba64-f8aa0290ff00)

### Visualizar todos os pátios:

![lerPatio](https://github.com/user-attachments/assets/797ae293-d4ad-45ed-8706-b20baaaca689)

### Deletar pátio:

![delPatio](https://github.com/user-attachments/assets/027862f1-111d-4f04-923e-0c731b3f320a)



### Requisições da parte de gerenciamento de âncoras:

### Cadastrar âncora:

![cadastrarAncora](https://github.com/user-attachments/assets/a13b6f95-63ff-4a14-b11f-b28428ec08a6)

### Visualizar âncora especifica:

![lerAncora](https://github.com/user-attachments/assets/5bfb142c-e4b4-4f00-b9bd-8afafab7c865)

### Atualizar posições da âncora:

![attAncora](https://github.com/user-attachments/assets/3e89e797-a6ea-45e0-917f-9e906e341503)

### Deletar âncora:

![delAncora](https://github.com/user-attachments/assets/0df4dcac-bd54-4c85-8b1d-d77f049e79b0)



### Requisições da parte de gerenciamento das motos no pátio(Parte mais importante):

### Associar data e hora de entrada da moto ao pátio:

![associarMotoPatio](https://github.com/user-attachments/assets/d3b2d10e-b070-4254-9aec-97b2900c2848)

### Pegar posicionamento da moto:
#### OBS** Como atualmente ainda não temos o hardware e não simulamos as placas esp32, estamos testando com dados mockados, cada parametro desta função com o nome "d" refere-se as distâncias que o ESP32 com UWB captaria em relação às âncoras fixas.

![posicaoMoto](https://github.com/user-attachments/assets/f2c79f3d-73a3-4e42-9e52-820d1100205a)

### Associar data e hora de saida da moto ao pátio:

![saidaMoto](https://github.com/user-attachments/assets/2fa10d60-1168-4599-a3a9-d485a12feeef)



## Arquivo pom.xml

![pompart1](https://github.com/user-attachments/assets/d7574387-a7c3-492c-9130-343d5c9229d7)
![pompart2](https://github.com/user-attachments/assets/f12c283e-ba5f-49ce-ae13-beaff8095d25)




