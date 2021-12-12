#include <iostream>
using std::cout;
using std::endl;
using std::cerr;
using std::isdigit;

#include <fstream>
#include <string>
#include <math.h>
#include <sstream>


int main(int argc, char* argv[])
{
    if( argc < 3  ||  !(std::isdigit(*argv[1])) )
    {
        cerr << "Por favor, informe os parâmetros corretamente." << endl;
        return 1;
    }
      
    int orderMatrix = std::atoi(argv[1]);
    char solution = *argv[2];

    // Verificar se é uma potência de 2
    float log = log2(orderMatrix);
    if( (log == 0) || (log - int(log) != 0) )
    {
        cerr <<  orderMatrix << " não é uma potência de 2. Tente novamente." << endl;
        return 1;
    }
    else if( solution != 'S' && solution != 'C' )
    {
        cerr << solution << " não é uma opção válida. Tente novamente." << endl;
        return 1;
    }

    // Variáveis auxiliares para leitura das matrizes
    int M, N; // dimensões
    std::string line;
    std::string name_file;
    std::stringstream stream;

    // Abrir arquivo da matriz A
    name_file = "../matrizes/A"+std::to_string(orderMatrix)+"x"+std::to_string(orderMatrix)+".txt";
    std::ifstream inputFileA(name_file, std::ios::in);
    if(!inputFileA.is_open()){
        cerr << "Erro ao ler arquivo: " << name_file << endl;
		return 1;
	}

    // Ler dimensões da matriz A
    std::getline(inputFileA, line);
    stream << line;
    stream >> M >> N;

    int matrixA[M][N];
    // Ler matriz A
    for(int i=0; i<M; i++) {
        std::getline(inputFileA, line);

        stream.clear();
        stream << line;

        for(int j=0; j<N; j++)
            stream >> matrixA[i][j];
    }
    inputFileA.close();


    // Abrir arquivo da matriz B
    name_file = "../matrizes/B"+std::to_string(orderMatrix)+"x"+std::to_string(orderMatrix)+".txt";
    std::ifstream inputFileB(name_file, std::ios::in);
    if(!inputFileB.is_open()){
        cerr << "Erro ao ler arquivo: " << name_file << endl;
        return 1;
    }

    // Ler dimensões da matriz B
    std::getline(inputFileB, line);
    stream.clear();
    stream << line;
    stream >> M >> N;
    
    int matrixB[M][N];
    // Ler matriz B
    for(int i=0; i<M; i++) {
        std::getline(inputFileB, line);
        
        stream.clear();
        stream << line;

        for(int j=0; j<N; j++)
            stream >> matrixB[i][j];
    }
    inputFileB.close();


    // 

    return 0;
}