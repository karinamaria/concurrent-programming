#include "matrix.h"
#include <iostream>
#include <thread>

namespace matrix {
	void multiply_matrices_sequential( T **A, T **B, T **C, int m, int n, int p ) {
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int soma = 0;
				for(int k=0; k<p; k++){
					soma= soma + (A[i][k]*B[k][j]);
				}
				C[i][j]=soma;
			}
		}
	}

	void multiply_matrices_threading(const int number_thread,  T **A, T  **B, T **C) {

	}

	void multiply_matrices_concurrent( T **A, T **B, T **C, int m, int n, int p ) {
		const int number_threads = log2(m);
		std::thread threads[number_threads];

		for (int i = 0; i < number_threads; ++i) {
			threads[i] = std::thread(multiply_matrices_threading, i,  A, B, C);
		}
		for (int i = 0; i < number_threads; ++i) {
			threads[i].join();
		}

	}
}