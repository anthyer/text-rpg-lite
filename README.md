<p align="center">
<img src="/Images/ifsc-logo.png" width="180" height="180">
</p>

**INSTITUTO FEDERAL DE SANTA CATARINA**  
Análise e desenvolvimento de Sistemas - 1ª fase  
ALG786201 - Pensamento computacional e Algoritmos  
**Professor:** Ramon Mayor Martins  
**Discente:**  Antonio Marcos da Silva

---

<h1 align="center">Text RPG Lite</h1>

## Tópicos

- [Introdução](#1-introdução)
- [Objetivos da Atividade](#2-objetivos-da-atividade)
- [Descrição da Atividade](#3-descrição-das-atividades)
- [Estrutura do jogo](#4-estrutura-do-jogo)
- [Conclusão](#5-conclusão)

## 1. Introdução

<p align="justify"> &emsp; O projeto se refere à atividade avaliativa da disciplina de Pensamento Computacional e Algoritmos.</p>
<p align="justify"> &emsp; Foi desenvolvido um jogo na linguagem de programação Java, utilizando os conceitos de Algoritmo, Programação Orientada a Objetos e padrão de arquitetura MVC.</p>

### Técnologias utilizadas+
<p display="inline-block">
<img width="32" src="/Images/git.png" alt="GitLogo.png">
<img width="32" src="/Images/github(1).png" alt="GitHubLogo.png">
<img width="32" src="/Images/java.png" alt="JavaLogo.png">
</p>

## 2. Objetivos da atividade

<p align="justify"> &emsp; A atividade realizada teve como objetivo principal o exercício das habilidades de pensamento computacional e algoritmos bem como a utilização da linguagem de programação Java.</p>

## 3. Descrição das atividades

<p align="justify"> &emsp; Foi desenvolvido um jogo simples de RPG Textual, onde o jogador controla um paladino que tem de enfrentar um inimigo, o Hobgoblin.</p>
<p align="justify"> &emsp; RPG refere-se a Role Playing Game, onde o jogador assume o papel de algum personagem fictício, geralmente de sua altoria, onde deve passar por diversos desafios propostos pelo Mestre da Mesa, neste caso os desafios foram scriptados em Java.</p>
<p align="justify"> &emsp; O desafio proposto é uma batalha contra um inimigo, para atacar basta digitar 'atacar' e serão feitos cálculos com base em um sistema pré-definido de rolagens de dados e habilidades pré-definidas dos personagens (inimigo ou personagem jogável).</p>

## 4. Estrutura do jogo

### 4.1 A arquitetura

<p align="justify"> &emsp; A arquitetura de organização do código foi a MVC:</p>

- **Model**: Contém os modelos das classes a serem utilizadas no jogo, como inimigo e paladino.
- **View**: Contém a classe responsável por colocar as informações na tela para o jogador saber o que está acontecendo. É a interface gráfica do jogo.
- **Control**: Contém a classe responsável por controlar o fluxo do jogo, mantendo o gameplay ativo.
- **Utils**: Contém as classes utilitárias como o rolador de dados e a classe para auxiliar na obtenção dos modificadores de habilidades.
- **main**: Classe responsável por iniciar o jogo e fornecer informações primordiais às demais.

### 4.2 Fluxo de gameplay

<p align="justify"> &emsp; O jogador inicia o jogo inserindo o nome do seu paladino, a seguir são apresentados as habilidades e seus modificadores. Todas as habilidades são calculadas com base na rolagem de 3 dados de 6 lados e somados com números de acordo com a classe do personagem, nesse caso o Paladino (+2 em Força e +2 em Constituição). As habilidades recebem modificadores, esses utilizados nos cálculos de habilidades ou ataques do personagem, os modificadores recebem um incremento a cada nível par, sendo 10 modificador 0.</p>
<p align="justify"> &emsp; A seguir, o jogador é apresentado ao combate do jogo, onde deve enfrentar seu inimigo, o Hobgoblin. Para atacar basta digitar 'atacar', assim é calculada a jogada de ataque, composto da soma do resultado de uma rolagem de um dado de 20 lados mais o bônus de jogada de ataque do personagem mais o modificador de força. Se essa jogada de ataque superar a classe de armadura do inimigo, o ataque é certeiro. Assim é calculado o dano, que é composto do resultado de um dado de 8 lados mais o modificador de força. O inimigo também realizará um ataque, com cálculos realizados da mesma forma.</p>
<p align="justify"> &emsp; Caso ao tirar 20 em um dado de 20 faces, o ataque será crítico, multiplicado o dado da rodada por 3. Isso pode ocorrer tanto para o jogador quanto para o inimigo. O jogo é finalizado quando um dos personagens chega a 0 de vida.</p>

## 5. Conclusão

<p align="justify"> &emsp; A realização da referida atividade avaliativa foi de grande proveito pois proporcionou pôr em prática todos os conhecimentos obtidos durante o semestre. Desta forma, foi um grande exercício das habilidades, gerando muito conhecimento empírico.</p>
<p align="justify"> &emsp; O projeto foi concluído com sucesso atendendo as diretivas desejadas, que era a criação de uma base para um possível futuro jogo de RPG. Há muitas possibilidades de expensão, sendo algumas delas a implementação de outras classes jogáveis, outras habilidades para serem utilizadas durante o combate além do ataque, como manobras de batalha, magias, utilização de itens, etc... O Jogo possui muitos caminhos de expansão agora que a base foi concluída.</p>
