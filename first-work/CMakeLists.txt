cmake_minimum_required(VERSION 3.5)
project(ConcurrentProgramming)

set ( CMAKE_CXX_FLAGS "-Wall" )

include_directories( include )

add_executable( main
                src/Main.cpp # This has the application main().
                src/matrix.cpp # This has the matrix functions implementation.
                src/timing.cpp ) # This has the timing functions implementation.

set_property(TARGET main PROPERTY CXX_STANDARD 11)
