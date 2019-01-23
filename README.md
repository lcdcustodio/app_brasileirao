# O Desafio App Brasileir�o foi finalizado! 

----
##Passo a passo utilizado no desenvolvimento da aplica��o:

**1. Defini��o das APIs** 

Foram implementadas 02 APIs (baseadas em JSON) utilizando o m�todo POST atrav�s do protocolo HTTP. A primeira desenvolvida para entregas as informa��es da Tela Inicial (lista de jogos, nome dos times, escudos, placar, data e hor�rio) e a segunda fornecendo o conte�do da  Tela com os melhores momentos das partidas lance a lance. 

**As APIs s�o chamadas atrav�s da URL:**

    http://ec2-52-90-92-199.compute-1.amazonaws.com/xmiles/login/index.php

**Par�metros enviados para chamadas das APIs s�o:**

> Tela Inicial

    String tag = "jogos";

> Tela Detalhes do jogo

    String tag = "lances";
    String sigla_host = "SIGLA TIME COM MANDO DE CAMPO"
    String sigla_guest = "SIGLA TIME VISITANTE"

A API foi desenvolvida em PHP. O webservice PHP consulta os dados em um banco PostgreSQL. A solu��o de Backend est� hospedada em uma inst�ncia AWS.

----
**2. Estrutura do frontEnd** 

A aplica��o foi desenvolvida para o Android. Foram criadas 02 Telas seguindo as instru��es do desafio. 

* **Tela Inicial (descri��o dos principais itens desenvolvidos)**
 * Activity *Welcome.java* � kickoff da aplica��o

 * Fragment *Splash_Fragment.java*  - Lan�a a Tela de abertura. Realiza chamada ass�ncrona da API atrav�s das classes *UserFunctions.java* e *JSONParser.java*. Repassa o resultado JSON da API para o pr�ximo fragmento (Jogos_Fragment.java)
  
 * Fragment  *Jogos_Fragment.java*  - Lan�a a Tela principal com os Jogos (lista de jogos, nome dos times, escudos, placar, data e hor�rio). Utiliza diversos recursos de layout (LinearLayout, RelativeLayout, View,...) e widgets (Textview, Listview,...) dispon�veis nas bibliotecas de UI do android para *renderizar* as informa��es referentes aos jogos. Utiliza a biblioteca *volley.jar* do Google para  carregar as imgurls dos escudos dos clubes. Para atender o requisito do desafio - **O usu�rio pode querer atualizar a lista de jogos** - foi acrescentado o componente  *SwipeRefreshLayout*  da biblioteca *android.support.v4*.  Ele faz uma chamada ass�ncrona da API atrav�s da classe *SwipeRefreshAsyncTask.java* com o objetivo de atualizar as informa��es dos jogos. Para atender outro requisito do desafio - **Clicar sobre um jogo leva o usu�rio para a tela de detalhe daquele jogo** - a aplica��o abre uma nova Activity (Lances.java) ao clicar sobre qualquer partida. Nesse evento tamb�m ocorre a transmiss�o de 02 par�metros para a nova Tela � *sigla_host* e *sigla_guest*.
  
* **Tela Detalhes dos jogos (descri��o dos principais itens desenvolvidos)**
* Activity *Lances.java* � Recebe os par�metros enviados (*sigla_host* e *sigla_guest*) e repassa para o fragmento *DownloadLances_Fragment.java*. Utiliza o recurso *AppCompactActivity* (m�todo getSupportActionBar()) da biblioteca appcompat-v7 com objetivo de atender requisito do desafio  - **Atalho para voltar para a tela inicial**

 * Fragment * DownloadLances_Fragment.java *  - Lan�a a Tela de passagem (similar ao *Splash_Fragment.java*) para a Tela com os lances e detalhes da partida. Realiza chamada ass�ncrona da API atrav�s das classes *UserFunctions.java* e *JSONParser.java* e par�metros *sigla_host* e *sigla_guest*. Repassa o resultado JSON da API para o pr�ximo fragmento (Lances_Fragment.java)
 
* Fragment  * Lances_Fragment.java* - Lan�a a Tela com os detalhes do jogo e melhores momentos lance a lance. Utiliza diversos recursos de layout (LinearLayout, RelativeLayout, FrameLayout, View,...) e widgets (Textview, Listview,...) dispon�veis nas bibliotecas de UI do android para *renderizar* as informa��es referentes aos jogos e melhores momentos lance a lance. Utiliza a biblioteca *volley.jar* do Google para  carregar as imgurls dos escudos dos clubes e fotos dos jogadores dentro do feed lance a lance.

----
##

**E Se tivesse mais tempo para o desafio**

* Utilizaria o recurso RecyclerView para criar as listas das Telas ao inv�s do ListView. O componente RecyclerView da biblioteca android.support.v7 � uma evolu��o do recurso ListView. Utilizei o ListView no desafio com objetivo de otimizar o tempo, pois � um recurso que tenho maior conhecimento. Com mais tempo estudaria o  RecyclerView para aproveitar a sua capacidade.

* Utilizaria Android Studio ao inv�s do Eclipse para desenvolver o projeto. Utilizei Eclipse, pois n�o sou administrador da minha esta��o de trabalho e o Android Studio n�o � um software homologado pela minha empresa. Com mais tempo teria providenciado outro notebook para utilizar o Android Studio. 

* Implementaria uma rotina para avisar o usu�rio a respeito da falta de conectividade de rede. Na vers�o atual esse mecanismo n�o foi previsto. Logo, a experi�ncia de uso do app nessa condi��es (falta de internet) ser� prejudicada.

* Implementaria Notifica��o via Push no app para alertar de gols, destaques, etc.
