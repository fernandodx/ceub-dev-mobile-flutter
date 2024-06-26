# LEIA A DOCUMENTAÇÃO SOBRE ACTIVITY E RESPONDA:

> https://developer.android.com/guide/components/activities/intro-activities?hl=pt-br

### 1. Qual é a principal diferença entre a inicialização de aplicativos em sistemas Android em comparação com outros paradigmas de programação?
* ~~a) Os aplicativos Android iniciam com um método main(), enquanto outros sistemas iniciam com uma instância de Activity.~~
- b) Os aplicativos Android iniciam com uma instância de Activity, enquanto outros sistemas iniciam com um método main().
* ~~c) Os aplicativos Android iniciam com uma instância de Service, enquanto outros sistemas iniciam com um método main().~~
- d) Os aplicativos Android iniciam com uma instância de Broadcast Receiver, enquanto outros sistemas iniciam com um método main().

**Resposta: B**

### 2. O que é uma Activity em um aplicativo Android?
- ~~a) Uma função específica de gerenciamento de banco de dados.~~
* b) Uma classe especializada em operações de entrada e saída.
- ~~c) Uma interface de usuário visível que permite a interação do usuário com o aplicativo.~~
* d) Uma classe responsável pela execução de tarefas em segundo plano.

**Resposta: D**

### 3. Qual é o propósito principal da classe Activity em um aplicativo Android?
* ~~a) Gerenciar a lógica de negócios do aplicativo.~~
- ~~b) Manipular a comunicação entre componentes do aplicativo.~~
* c) Facilitar a interação do usuário com o aplicativo.
- ~~d) Realizar operações de entrada e saída de dados.~~

**Resposta: C**

### 4. Como é possível definir uma Activity no manifesto de um aplicativo Android?
- ~~a) Através do elemento < service>.~~
* ~~b) Através do elemento < broadcastreceiver>.~~
- c) Através do elemento < intent-filter>.
* d) Através do elemento < activity>.

**Resposta: D**

### 5. O que é necessário para uma Activity poder ser iniciada por outra atividade ou componente em um aplicativo Android?
* ~~a) A atividade precisa ser declarada no arquivo de manifesto do aplicativo.~~
- ~~b) A atividade precisa estar na mesma classe que a atividade chamadora.~~
* c) A atividade precisa ser declarada dentro da classe Application.
- d) A atividade precisa ter uma instância de Broadcast Receiver associada.

**Resposta: D**

### 6. Qual é a principal função do callback onCreate() em uma Activity?
- a) ~~Iniciar a atividade quando o usuário a seleciona.~~
* b) Inicializar componentes essenciais da atividade, como visualizações e layouts de interface do usuário.
- ~~c) Atualizar a interface do usuário quando a atividade é retomada.~~
* ~~d) Lidar com a pausa da atividade quando o usuário a minimiza.~~

**Resposta: B**

### 7. Quando o sistema chama o callback onStop() em uma Activity?
- ~~a) Quando a atividade está prestes a ser destruída.~~
* ~~b) Quando a atividade entra em primeiro plano e se torna interativa.~~
- c) Quando a atividade não está mais visível para o usuário.
* ~~d) Quando a atividade está em segundo plano, mas ainda visível.~~

**Resposta: C**

### 8. O que é recomendado não fazer dentro do callback onPause() de uma Activity?
* a) Realizar operações de entrada e saída de dados.
- ~~b) Atualizar a interface do usuário.~~
* c) Salvar dados de aplicativos ou usuários.
- d) Executar transações de banco de dados.

**Resposta: C e D**

### 9. Qual é o último callback que uma Activity recebe antes de ser destruída?
- ~~a) onPause()~~
* ~~b) onStop()~~
- c) onDestroy()
* ~~d) onRestart()~~

**Resposta: C**

### 10. Como uma Activity é identificada em um aplicativo Android?
* a) Através de um ID único gerado automaticamente pelo sistema.
- b) Pelo nome da classe da Activity especificada no arquivo de manifesto do aplicativo.
* c) Através de uma chave exclusiva fornecida pelo desenvolvedor.
- d) Pelo número de instâncias criadas durante a execução do aplicativo.


**Resposta: B**
