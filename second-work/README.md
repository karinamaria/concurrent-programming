# Lista Simplesmente Encadeada
O objetivo desse trabalho é implementar uma lista simplesmente encadeada concorrente

# A Concorrência
O acesso é compartilhado por três tipos de threads: o tipo B realiza operações de busca sobre a lista, 
o tipo I realiza operações de inserção de itens no final da lista e o tipo R realiza operações de 
remoção de itens a partir de qualquer posição da lista.

- Threads do tipo B meramente realizam operações de leitura sobre a lista e, portanto, podem ser executadas
  de forma simultânea com as outras;
- Threads do tipo I devem ser mutuamente exclusivas a fim de impedir que duas threads estejam inserindo itens 
  no final da lista ao mesmo tempo.
- Thread do tipo R pode acessar a lista por vez para realizar remoção de itens e essa operação deve ser mutuamente exclusiva com relação às demais
  (busca e inserção).

# A solução

1. Utilizamos o `ReadWriteLock` do Java
2. A exclusão mútua é garantida porque enquanto uma thread está com o lock de escrita nenhuma outra thread consegue obter o writeLock() e readLock(). Diferente do que acontece com o readLock() que pode ser obtido por diferentes threads de leitura ao mesmo tempo.
Garantimos a ausência de deadlock porque sempre que finalizamos uma operação, liberamos o lock para ser usado por outras threads. A ausência de condições de starvation é tratada quando instanciamos a classe ReentrantReadWriteLock passando para o construtor o parâmetro fair como true. O parâmetro fair indica se que o bloqueio deve usar uma política de ordenação justa


# Como executar este projeto

Para executar localmente é necessário ter instalado na sua máquina: JDK
```
git@github.com:karinamaria/concurrent-programming.git
```
Abra o projeto em uma IDE de sua preferência. E execute a classe `main.java`

# Desenvolvedoras

* Karina Maria [@karinamaria](https://github.com/karinamaria/)
* Maria Eduarda [@mariaeloi](https://github.com/mariaeloi/)