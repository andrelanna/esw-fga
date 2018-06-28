# Trabalho Final Ruby on Rails

## Pergunta 1
### 1 - O que é framework? Qual seu propósito (desenvolvimento web, mobile, frontend)? Como ele é estruturado (há diagrama de classes, arquitetural, dentre outros)? Quais são os pontos de extensão de funcionalidades desse framework (hot-spots)? <br>
- Qual o modelo de componente definido para o framework? Ele está publicamente definido e acessível? <br>

### 1.1 O que é FrameWork

  Um framework é um conjunto lógico que tem por objetivo fornecer uma estrutura lógica comum entre projetos, podendo ser utilizado em âmbito organizacional como no caso dos framework de desenvolvimento ou em escopo de código.

  O framework em estudo neste trabalho está dentro do escopo de código, os framework de código possuem a característica de serem um conjunto de classes com lógicas genéricas reutilizáveis, que tem como objetivo reduzir trabalho e repetição de código em um projeto.

  Para que ocorra a reutilização de código os frameworks possuem pontos de extensão para suas funcionalidades estes podendo ser divididos entre hotspots e frozen spots, onde os hot spots são pontos de extensão permissivos onde adaptações no código podem ser realizadas, geralmente por herança, e os frozen spots são pontos onde não há a possibilidade de alteração da lógica imposta pelo framework.

  ## 1.2. Ruby on Rails

  ### 1.2 Propósito

  O framework ruby on rails e voltado para o desenvolvimento de aplicações web na linguagem ruby, prestando auxílio em quesitos comuns em aplicações web como requisições, protocolos HTTP, armazenamento em banco de dados entre outros.

  Para realizar essas funções o ruby on rails tenta engessar o desenvolvimento ao padrão arquitetural model-views-controller prestando pontos de extensão para cada camada do modelo arquitetural.

  ### 1.3 Estrutura

  ![module_view](./imgs/static_view.png)<br>
  Imagem 1 - Diagrama de Classe (Module View)

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

### 1.4 Principais Pontos de Extensão
Os principais pontos de extensão do Rails são os arquivos das Models e os arquivo das Controllers:

ActionController e ApplicationRecord.

**ActionController** é um módulo (module), ou seja, uma coleção de métodos e constantes que dão vida as controllers do Rails. Esse módulo é estendido em todas as controllers de um projeto em Rails, assim o desevolvedor tem uma conexão entre lógica de negócio (controller), as ações do banco de dados (através da model) e também entre a demonstração de dados para o cliente através das views. Cada controller possui a implementação das conexões HTTP (definidas nas rotas), desde de o entendimento de diferentes formatos, por exemplo o JSON, como também na interpretação dos parâmentros que são passados em cada requisição. A ActionController consegue lidar com isso tudo ser receber alterações do usuário desenvolvedor. Assim o desenvoldor consegue trabalhar com as controllers do Rails sem se preocupar com toda essa parte genérica de conexões.

**ActiveRecord** é também um módulo do Rails, responsável por representar os dados e a lógica de negocio de cada entidade do banco de dados. As classes do Rails, localizadas na model, estendem do ActiveRecord. É um ponto de extensão incrível do Rails pois permite que o desenvolvedor crie tabelas, regras de negocio para essas tabelas ([as validations](http://guides.rubyonrails.org/active_record_validations.html)) sem escrever nada em linguagem de banco, sql ou qualquer coisa do tipo. É um módulo que automatiza uma importante atividade do desenvolvimento web, porém que mantém flexivel o suficiente para que o desenvolvedor consiga usar nos mais variados cenários. Além disso o ActiveRecord já adiciona em cada classe os métodos de CRUD, além de vários outros métodos que são úteis no desenvolvimento web, como os callbacks de DB por exemplo.

### 1.5 Modelo de Componente definido para o Rails
Podemos dizer que os componentes do Rails são basicamente *modules* incluidos no application.rb, que ficam disponíveis em toda a aplicação. Entre os módulos principais podemos citar: action mailer, action pack, action view, active job, active model, active record, active support. Esses componentes são definidos no próprio framework e podem ser acessados (até mesmo alterados) em qualquer aplicação em Rails. Além desses componentes o framework conta com a adição de pacotes, as gems, que em alguns casos pelo fato de serem relativamente genéricas e em muitos casos reutilizáveis, algumas gems possuem muitas características de componentes e podem serem tratadas como tal. Porém nos casos das gems nem sempre todas as clases e módulos da mesma ficam acessíveis para alteração pelo desenvolvedor. Assim para esse tipo de componente é necessário uma análise particular, para entender como ele foi definido e estruturado e assim determinar o quanto ele é acessível

## Pergunta 2
### 2.1 - O que é um componente de software para o framework adotado e como ele é estruturado?<br>

Para o Rails um componente é uma unidade independente que pode ser usada separadamente ou em conjunto com outras partes do framework. Sua estrutura é projetada através de pacotes.


### 2.2 - Como os detalhes de sua implementação são ocultados dos framework?<br>

### 2.3 - Como suas interfaces de comunicação / composição devem ser definidas?<br>

Suas interfaces de comunicação são definidas como classes abstratas e/ou concretas, sendo que as classes concretas trazem funcionalidades prontas para serem utilizadas a partir de herança como é o caso do ActiveRecord que implementa a classe Base como concreta, ou o ApplicationController herdando de uma classe abstrata ActionController.

### 2.4 - Como componentes de software são adaptados para o framework sob investigação? Glue-code? Herança? Adapter? etc...

Há duas maneiras de adaptar componentes para o Rails, uma vez que este framework é considerado framework de framework, vamos analisar algumas tecnicas utilizadas

**Glue-code:** está tecnica é usada para integrar integrar componentes que não são compativeis como gems que não tem caracteristicas de framework.

**Herança:** Esta tecnica é usada para integrar componentes onde os aspectos internos estão disponíveis para o Rails tais como gems com característica de framework onde os pontos de extensão se comportam como caixa-branca

## Pergunta 3
### 3 - Quais são os modos  geralmente utilizados para composição componentes / frameworks?<br>
- Como se dá a comunicação entre componentes / framework?<br>
- Há um diagrama comportamental (sequencia, colaboração, etc) que demonstre tal comunicação?


### 3.1 Modos de para a Composição de Componentes/Frameworks

Existem 3 principais modos para a interação ou composição de Componentes/Frameworks:

- Esta composição define as funcionalidades da aplicação por meio das interações entre os componentes. Essas interações são tratadas como um contrato em nível de aplicação.

- Trata-se de uma composição que permite a comunicação entre frameworks de componentes e seus componentes. Gerenciar essas interações qualificam um contrato em nível de sistema.

- Permite a interações entre frameworks, além da composição de componentes de diferentes frameworks. Esta interação classifica um contrato de interoperação.


### 3.2 Comunicação entre os Componentes

A comunicação entre os Componentes do Ruby on Rails pode ser observada e analisada a partir de 2 modos de visualização em UML, sendo um deles o Module View (observe a Imagem 1, no tópico de estrutura), que apresenta todos os componentes do framework de forma estática, e outro chama-se Component & Connector View, que exibe os componentes da forma com que eles existem em tempo de execução e como eles se comunicam entre si.

![cc_view](./imgs/dynamic_view.png)<br>
Imagem 2 - Component & Connector View

### 3.3 Diagrama comportamental

![cc_view](./imgs/rails_diagram.png)<br>
Imagem 3 - Diagrama Comportamental
