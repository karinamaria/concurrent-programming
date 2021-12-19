# Objetivo
Realizar análise empírica dos algoritmos de multiplicação de matrizes na forma sequencial e concorrente

# Compilação

Para compilar esse projeto com o [cmake](https://cmake.org) siga os passos:

1. `cd concurrent-programming/first-work`: entra no diretório principal do projeto
2. `cmake -S . -Bbuild`:  O cmake cria um diretório build e gera um Makefile baseado no script encontrado em `CMakeLists.txt`
3. `cd build`: entra no diretório `build`
5. `cmake --build .` or `make`: aciona o processo de compilação

Os executáveis estarão no diretório `build`

# Observações
Antes de executar o programa, certifique-se de possuir as seguintes pastas:
1. `out/matrizes`: para saída das matrizes produto
2. `out/tempo/S`: para saída dos tempos de execução do algoritmo sequencial
3. `out/tempo/C`: para saída dos tempos de execução do algoritmo concorrente


# Execução
No diretório principal do projeto, execute:

```
$ ./build/main
```

# Discentes

- Karina Maria
- Maria Eduarda
