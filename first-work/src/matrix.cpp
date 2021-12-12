#include "matrix.h"
#include <iostream>

namespace matrix {
	void multiply_matrices_sequential( T **A, T **B, T **C, int m, int n, int p ) {
		std::cout << "sequential..." << std::endl;
	}

	void multiply_matrices_concurrent( T **A, T **B, T **C, int m, int n, int p ) {
		std::cout << "concurrent..." << std::endl;
	}
}