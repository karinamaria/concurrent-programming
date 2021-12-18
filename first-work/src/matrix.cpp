#include "matrix.h"
#include <iostream>
#include <thread>
#include <math.h>

namespace matrix {
	void multiply_matrices_sequential( T **A, T **B, T **C, int m, int n, int p ) {
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				T sum = 0;
				for(int k=0; k<p; k++){
					sum += (A[i][k]*B[k][j]);
				}
				C[i][j]=sum;
			}
		}
	}

	void multiply_matrices_threading( const int &total_threads, const int &number_thread, T **A, T **B, T **C, const int &m, const int &n, const int &p ) {
		// número de elementos da matriz produto
		const int number_elements = m * n;
		// número de operações que a thread terá que fazer
		const int number_operations = number_elements / total_threads;
		// resto do número de operações dividido pelo total de threads
		const int rest_operations = number_elements % total_threads;
		
		int start_op = number_operations * (number_thread-1);
		int end_op = (number_operations * number_thread) + rest_operations;

		for (int op = start_op; op < end_op; ++op)
		{
			const int row = op % p;
			const int col = op / p;

			T sum = 0;
			for (int i = 0; i < p; ++i)
				sum += A[row][i] * B[i][col];

			C[row][col] = sum;
		}
	}

	void multiply_matrices_concurrent( T **A, T **B, T **C, int m, int n, int p ) {
		const int total_threads = log2(m);
		std::thread threads[total_threads];
		
		for (int i = 0; i < total_threads; ++i) {
			threads[i] = std::thread(multiply_matrices_threading, total_threads, i+1,  A, B, C, m, n, p);
		}
		for (int i = 0; i < total_threads; ++i) {
			threads[i].join();
		}

	}
}