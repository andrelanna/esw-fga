# Trabalho Final Ruby on Rails

## Pergunta 1
1.1 - O que é framework? <br>
1.2 - Qual seu propósito (desenvolvimento web, mobile, frontend)?  <br>
1.3 - Como ele é estruturado (há diagrama de classes, arquitetural, dentre outros)?  <br>
1.4 - Quais são os pontos de extensão de funcionalidades desse framework (hot-spots)? <br>
1.5 Qual o modelo de componente definido para o framework? Ele está publicamente definido e acessível? <br>

### 1.1 O que é FrameWork

  Um framework é um conjunto lógico que tem por objetivo fornecer uma estrutura lógica comum entre projetos, podendo ser utilizado em âmbito organizacional como no caso dos framework de desenvolvimento ou em escopo de código.

  O framework em estudo neste trabalho está dentro do escopo de código, os framework de código possuem a característica de serem um conjunto de classes com lógicas genéricas reutilizáveis, que tem como objetivo reduzir trabalho e repetição de código em um projeto.

  Para que ocorra a reutilização de código os frameworks possuem pontos de extensão para suas funcionalidades estes podendo ser divididos entre hotspots e frozen spots, onde os hot spots são pontos de extensão permissivos onde adaptações no código podem ser realizadas, geralmente por herança, e os frozen spots são pontos onde não há a possibilidade de alteração da lógica imposta pelo framework.

  ## 1.2. Ruby on Rails

  ### 1.2 Propósito

  O framework ruby on rails e voltado para o desenvolvimento de aplicações web na linguagem ruby, prestando auxílio em quesitos comuns em aplicações web como requisições, protocolos HTTP, armazenamento em banco de dados entre outros.

  Para realizar essas funções o ruby on rails tenta engessar o desenvolvimento ao padrão arquitetural model-views-controller prestando pontos de extensão para cada camada do modelo arquitetural.

  ### 1.3 Estrutura

  #### 1.3.1 Módulos

  ***Action Mailer***

  Esse módulo é responsável por prover o serviço de e mail, os componentes contidos neste módulo podem ser utilizados através de hotspots, onde há a herança de classes abstratas.

  ***Action Pack***

  O módulo das  Action Pack prover ao rails 3 sub-módulos:

  * Action Dispatch

  É um módulo que possui a função de transmitir as informações das requisições, geralmente esse módulo é utilizado pelo próprio framework,
  porém pode ser utilizado pelo usuário do framework se necessário.

  * Action Controller

  É o módulo que realiza o controle do fluxo de negócio, fazendo a comunicação e o processamento entre a view e a model,as classes contidas neste módulo geralmente são utilizadas com pontos hotspots.

  * Action View

  É chamada pela Action Controller e tem a função de apresentar a páginas requisitadas.

  ***Active Model***

  Define um modo de acesso entre a controller e a active Record. 

  ***Active Record***

  Esse módulo é responsável pelo mapeamento objeto relacional das classes, é acessada através de hotspots, onde é feito o mapeamento das classes filha no banco de dados.


