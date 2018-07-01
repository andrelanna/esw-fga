Questão 1)

Resposta:
  a) 
    i - TestCases são os casos de teste de fato, ou os métodos criados para testar algo em específico como testar a soma de 1 + 1;
    ii - TestSuite contempla a definição de uma série de tipos de test cases, onde, pode-se inclusive definir a ordem a qual cada classe de teste deve ser executada, a partir da definição das mesmas dentro da suite de testes;
    iii - Asserts são os verificadores que definem se o teste está correto ou não, os quais dependem geralmente de valores esperados e de valores atuais para fazer a verificação. Exemplo: assertEquals, assertTrue, entre outros.
    iv - TestRunners são executadores de TestCases, ou seja, garantem como os testes executam, podendo ser de diversos tipos como Suite, Parameterized, Mockito, JMockit.

  b)
    i - Suite: define a execução de uma série de classes de testes ordenadamente pela sua declaração;
    ii - Parameterized: define a execução de testes permitindo a passagem de parâmetros para eles;
    iii - JMockit: define a execução de testes permitindo o "mock" de classes ainda inexistentes.

  c) O JUnit consegue garantir a independência dos testes criando instâncias para cada teste a ser executado.