#ifndef TIMING_H
#define TIMING_H

#include <iostream>
#include "matrix.h"

typedef void(*Matrix)( matrix::T **A, matrix::T **B, matrix::T **C, int m, int n, int p );


double timer( int **A, int **B, int **C, int m, int n, int p, Matrix multiply_matrices_func );

void time_test( int **A, int **B, int m, int n, int p, Matrix multiply_matrices_func, std::string filename_output_matrix, std::string filename_output_time );

#endif