#ifndef MATRIX_H
#define MATRIX_H

namespace matrix {
	using T = int;

	void multiply_matrices_sequential( T **A, T **B, T **C, int m, int n, int p );

	void multiply_matrices_threading( const int &total_threads, const int &number_thread, T **A, T **B, T **C, const int &m, const int &n, const int &p );

	void multiply_matrices_concurrent( T **A, T **B, T **C, int m, int n, int p );
}

#endif