#include <iostream>
using std::cout;
using std::endl;
using std::cerr;
using std::isdigit;

#include <fstream>
#include <string>
#include <math.h>



int main(int argc, char* argv[])
{
     if(argc < 2  ||  !(std::isdigit(*argv[1])) )
     {
        cerr << "Por favor, informe os parâmetros corretamente" << endl;
        return 1;
    }

    //verifique se é uma potência de 2
    cout << log2(std::atoi(argv[1])) <<endl;
    /**std::string orderMatrix = argv[1];
    std::string  name_file = "../matrizes/A"+orderMatrix+"x"+orderMatrix+".txt";
    std::ifstream inputFile(name_file, std::ios::in);
    if(!inputFile.is_open()){
        cerr<<"Erro ao ler arquivo"<<endl;
		return 1;
	}

	std::string line;
	while (!inputFile.eof()) {
    	std::getline(inputFile, line);
    	if (line.size() == 0) {
      		continue;
    	}

    	cout << line << endl;
  	}**/
    return 0;
}