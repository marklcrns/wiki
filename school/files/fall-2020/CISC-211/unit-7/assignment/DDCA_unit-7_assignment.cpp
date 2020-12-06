#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{

	int dividend = 9;         	// R0 = A (dividend)
	int divisor = 2;          	// R1 = B (divisor)
	int i = 0;                	// MOV R2, #0
	int tmp = divisor;        	// MOV R3, R1

	int quotient;

	// L1
	while (dividend >= tmp) { 	// CMP R1, R0 ? Proceed : BHI DONE
		i = i + 1;              // ADD R2, R2, #1
		tmp = tmp + divisor;    // ADD R1, R1, R3
	}

	// DONE
	quotient = i;             	// MOV R0, R2
	
	cout << "\nThis code produces the following Result: " << quotient << endl;
	return 0;
}
