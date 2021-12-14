#include "timing.h"

#include <chrono>
#include <fstream> //ofstream

double timer( int **A, int **B, int **C, int m, int n, int p, Matrix multiply_matrices_func )
{
	auto start_time = std::chrono::steady_clock::now();

	multiply_matrices_func(A, B, C, m, n, p);

	auto end_time = std::chrono::steady_clock::now();
	std::chrono::duration<double> time = end_time - start_time;

	return std::chrono::duration<double, std::milli>(time).count();
}

void time_test( int **A, int **B, int m, int n, int p, Matrix multiply_matrices_func, std::string filename_output_matrix, std::string filename_output_time )
{
	int **C = new int*[m];
	for(int i=0; i<m; i++)
		C[i] = new int[n];

	// Abrir arquivo para registrar o tempo gasto
	// a escrita nesse arquivo será feita no final dele para não sobrescrever medições anteriores
	std::ofstream fileTime(filename_output_time, std::ios::app);
	if(!fileTime.is_open()){
        std::cerr << "Erro ao abrir arquivo: " << filename_output_time << std::endl;
        return;
    }

    double time = timer(A, B, C, m, n, p, multiply_matrices_func);

    // Salvar tempo gasto na multiplicação das matrizes
    fileTime << time << std::endl;
    fileTime.close();
    
    std::ofstream fileMatrix(filename_output_matrix);
	if(!fileMatrix.is_open()){
        std::cerr << "Erro ao abrir arquivo: " << filename_output_matrix << std::endl;
        return;
    }
    // Salvar matriz resultante
    fileMatrix << m << " " << n << std::endl;
 	for(int i=0; i<m; i++) {
 		for(int j=0; j<n; j++)
 			fileMatrix << C[i][j] << " ";
 		fileMatrix << std::endl;
 	}

    fileMatrix.close();
    
    for(int i=0; i<m; i++)
		delete[] C[i];
	delete[] C;
}