# 💾 DataSaver - Salvamentos de Dados

> AVISO: Este repositório não busca trazer um código (limpo, organizado ou bem estruturado), o objetivo deste repositório é um código funcional para salvar dados rapidamente para ter ao menos uma base.

# 📂 Tipos de Salvamento
## Serialização de Dados
> RECOMENDAÇÃO: Projetos pequenos ou bem estruturados!
- A serialização que ocorre neste processo tem como objetivo transformar o nosso objeto em questão em um arquivo que nomeamos de ``serialized-data.json``, após isto conseguimos fazer a deserialização do objeto e tê-lo novamente com base no arquivo que foi salvo, a serialização é rápida e prática.

![image](https://imgur.com/PIsdQjC.png)

## Salvamento com Separadores
> RECOMENDAÇÃO: Projetos pequenos ou testes!
- Os separadores usados neste processo é o ``:`` que irá separar (``Nome, Coins e Gemas``) do nosso jogador, as informações do objeto são colocadas em uma função que irá retornar uma ``String`` que logo será escrita no nosso arquivo criado ``separatedsplit-data``, para torná-lo um objeto novamente íremos criar um **Array de Strings**, que irá separá-lo em partes e após isto colocamos as informações no objeto.
- Observação: Existe um objeto nulo que irá receber as informações novas do objeto que acabou de ter suas linhas lidas e separadas para serem usadas.

![image](https://imgur.com/um4GLR0.png)