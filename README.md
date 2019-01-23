# O Desafio App Brasileirão foi finalizado! 

----
##Passo a passo utilizado no desenvolvimento da aplicação:

**1. Definição das APIs** 

Foram implementadas 02 APIs (baseadas em JSON) utilizando o método POST através do protocolo HTTP. A primeira desenvolvida para entregas as informações da Tela Inicial (lista de jogos, nome dos times, escudos, placar, data e horário) e a segunda fornecendo o conteúdo da  Tela com os melhores momentos das partidas lance a lance. 

**As APIs são chamadas através da URL:**

    http://ec2-52-90-92-199.compute-1.amazonaws.com/xmiles/login/index.php

**Parâmetros enviados para chamadas das APIs são:**

> Tela Inicial

    String tag = "jogos";

> Tela Detalhes do jogo

    String tag = "lances";
    String sigla_host = "SIGLA TIME COM MANDO DE CAMPO"
    String sigla_guest = "SIGLA TIME VISITANTE"

A API foi desenvolvida em PHP. O webservice PHP consulta os dados em um banco PostgreSQL. A solução de Backend está hospedada em uma instância AWS.

----
**2. Estrutura do frontEnd** 

A aplicação foi desenvolvida para o Android. Foram criadas 02 Telas seguindo as instruções do desafio. 

* **Tela Inicial (descrição dos principais itens desenvolvidos)**
 * Activity *Welcome.java* – kickoff da aplicação

 * Fragment *Splash_Fragment.java*  - Lança a Tela de abertura. Realiza chamada assíncrona da API através das classes *UserFunctions.java* e *JSONParser.java*. Repassa o resultado JSON da API para o próximo fragmento (Jogos_Fragment.java)
  
 * Fragment  *Jogos_Fragment.java*  - Lança a Tela principal com os Jogos (lista de jogos, nome dos times, escudos, placar, data e horário). Utiliza diversos recursos de layout (LinearLayout, RelativeLayout, View,...) e widgets (Textview, Listview,...) disponíveis nas bibliotecas de UI do android para *renderizar* as informações referentes aos jogos. Utiliza a biblioteca *volley.jar* do Google para  carregar as imgurls dos escudos dos clubes. Para atender o requisito do desafio - **O usuário pode querer atualizar a lista de jogos** - foi acrescentado o componente  *SwipeRefreshLayout*  da biblioteca *android.support.v4*.  Ele faz uma chamada assíncrona da API através da classe *SwipeRefreshAsyncTask.java* com o objetivo de atualizar as informações dos jogos. Para atender outro requisito do desafio - **Clicar sobre um jogo leva o usuário para a tela de detalhe daquele jogo** - a aplicação abre uma nova Activity (Lances.java) ao clicar sobre qualquer partida. Nesse evento também ocorre a transmissão de 02 parâmetros para a nova Tela – *sigla_host* e *sigla_guest*.
  
* **Tela Detalhes dos jogos (descrição dos principais itens desenvolvidos)**
* Activity *Lances.java* – Recebe os parâmetros enviados (*sigla_host* e *sigla_guest*) e repassa para o fragmento *DownloadLances_Fragment.java*. Utiliza o recurso *AppCompactActivity* (método getSupportActionBar()) da biblioteca appcompat-v7 com objetivo de atender requisito do desafio  - **Atalho para voltar para a tela inicial**

 * Fragment * DownloadLances_Fragment.java *  - Lança a Tela de passagem (similar ao *Splash_Fragment.java*) para a Tela com os lances e detalhes da partida. Realiza chamada assíncrona da API através das classes *UserFunctions.java* e *JSONParser.java* e parâmetros *sigla_host* e *sigla_guest*. Repassa o resultado JSON da API para o próximo fragmento (Lances_Fragment.java)
 
* Fragment  * Lances_Fragment.java* - Lança a Tela com os detalhes do jogo e melhores momentos lance a lance. Utiliza diversos recursos de layout (LinearLayout, RelativeLayout, FrameLayout, View,...) e widgets (Textview, Listview,...) disponíveis nas bibliotecas de UI do android para *renderizar* as informações referentes aos jogos e melhores momentos lance a lance. Utiliza a biblioteca *volley.jar* do Google para  carregar as imgurls dos escudos dos clubes e fotos dos jogadores dentro do feed lance a lance.

----
##

**E Se tivesse mais tempo para o desafio**

* Utilizaria o recurso RecyclerView para criar as listas das Telas ao invés do ListView. O componente RecyclerView da biblioteca android.support.v7 é uma evolução do recurso ListView. Utilizei o ListView no desafio com objetivo de otimizar o tempo, pois é um recurso que tenho maior conhecimento. Com mais tempo estudaria o  RecyclerView para aproveitar a sua capacidade.

* Utilizaria Android Studio ao invés do Eclipse para desenvolver o projeto. Utilizei Eclipse, pois não sou administrador da minha estação de trabalho e o Android Studio não é um software homologado pela minha empresa. Com mais tempo teria providenciado outro notebook para utilizar o Android Studio. 

* Implementaria uma rotina para avisar o usuário a respeito da falta de conectividade de rede. Na versão atual esse mecanismo não foi previsto. Logo, a experiência de uso do app nessa condições (falta de internet) será prejudicada.

* Implementaria Notificação via Push no app para alertar de gols, destaques, etc.
