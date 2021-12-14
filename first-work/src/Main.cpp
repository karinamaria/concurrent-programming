#include <iostream>
using std::cout;
using std::endl;
using std::cerr;
using std::isdigit;

#include <fstream>
#include <string>
#include <math.h>
#include <sstream>
#include "timing.h"


int main(int argc, char* argv[])
{
    if( argc < 3  ||  !(std::isdigit(*argv[1])) )
    {
        cerr << "Por favor, informe os parâmetros corretamente." << endl;
        return 1;
    }
    
    Matrix multiply_matrices_func;
    int orderMatrix = std::atoi(argv[1]);
    char solution = *argv[2];

    // Verificar se é uma potência de 2
    float log = log2(orderMatrix);
    if( (log == 0) || (log - int(log) != 0) )
    {
        cerr << orderMatrix << " não é uma potência de 2. Tente novamente." << endl;
        return 1;
    }
    
    switch(solution)
    {
        case 'S':
            multiply_matrices_func = matrix::multiply_matrices_sequential;
            break;
        case 'C':
            multiply_matrices_func = matrix::multiply_matrices_concurrent;
            break;
        default:
            cerr << solution << " não é uma opção válida. Tente novamente."  << endl;
            return 1;
    }

    // Variáveis auxiliares para leitura das matrizes
    int M, N, P, _P; // dimensões
    std::string line;
    std::string name_file;
    std::stringstream stream;

    // Abrir arquivo da matriz A
    name_file = "matrizes/A"+std::to_string(orderMatrix)+"x"+std::to_string(orderMatrix)+".txt";
    std::ifstream inputFileA(name_file, std::ios::in);
    if(!inputFileA.is_open()){
        cerr << "Erro ao ler arquivo: " << name_file << endl;
		return 1;
	}

    // Ler dimensões da matriz A
    std::getline(inputFileA, line);
    stream << line;
    stream >> M >> P;

    int **matrixA = new int*[M];
    for(int i=0; i<M; i++)
        matrixA[i] = new int[P];
    // Ler matriz A
    for(int i=0; i<M; i++) {
        std::getline(inputFileA, line);

        stream.clear();
        stream << line;

        for(int j=0; j<P; j++)
            stream >> matrixA[i][j];
    }
    inputFileA.close();


    // Abrir arquivo da matriz B
    name_file = "matrizes/B"+std::to_string(orderMatrix)+"x"+std::to_string(orderMatrix)+".txt";
    std::ifstream inputFileB(name_file, std::ios::in);
    if(!inputFileB.is_open()){
        cerr << "Erro ao ler arquivo: " << name_file << endl;
        return 1;
    }

    // Ler dimensões da matriz B
    std::getline(inputFileB, line);
    stream.clear();
    stream << line;
    stream >> _P >> N;

    if(P != _P) {
        cerr << "Matrizes incompatíveis: o número de colunas da matriz A é " << P
                << "enquanto o número de linhas da matriz B é " << _P << ".";
        return 1;
    }
    
    int **matrixB = new int*[_P];
    for (int i=0; i<_P; ++i)
        matrixB[i] = new int[N];
    // Ler matriz B
    for(int i=0; i<_P; i++) {
        std::getline(inputFileB, line);
        
        stream.clear();
        stream << line;

        for(int j=0; j<N; j++)
            stream >> matrixB[i][j];
    }
    inputFileB.close();

    //
    std::string filename_output_matrix = "out/matrizes/C"+std::to_string(orderMatrix)+"x"+std::to_string(orderMatrix)+".txt";

    std::string filename_output_time = "out/tempo/";
    filename_output_time += solution;
    filename_output_time += "/C"+std::to_string(orderMatrix)+"x"+std::to_string(orderMatrix)+".txt";

    time_test(matrixA, matrixB, M, N, P, multiply_matrices_func, filename_output_matrix, filename_output_time);

    for(int i=0; i<M; i++)
        delete[] matrixA[i];
    delete[] matrixA;

    for(int i=0; i<_P; i++)
        delete[] matrixB[i];
    delete[] matrixB;

    return 0;
}