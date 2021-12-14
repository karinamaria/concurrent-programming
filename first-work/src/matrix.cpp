#include "matrix.h"
#include <iostream>

namespace matrix {
	void multiply_matrices_sequential( T **A, T **B, T **C, int m, int n, int p ) {
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int soma = 0;
				for(int k=1; k<p; k++){
					soma= soma + (A[i][k]+B[k][j]);
				}
				C[i][j]=soma;
			}
		}
	}

	void multiply_matrices_concurrent( T **A, T **B, T **C, int m, int n, int p ) {
		std::cout << "concurrent..." << std::endl;
	}
}