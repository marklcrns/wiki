/*	lab6tut.c
 *		Created: 		7 November 2013
 *						Sarah_Lichtman@hmc.edu
 *		Last Modified: 	9 November 2013
 *						Sarah_Lichtman@hmc.edu
 *						
 *	Demonstrate switches, LEDs, console I/O
 */

#include <wiringPi.h> // This library makes GPIO with the Raspberry Pi easy
#include <stdio.h>    // The standard input/output library, used here for printing to the console

int main(){

	wiringPiSetup();
	// Pin numbering is according to wiringPi conventions.
	// Pins 9,7,0,2,3,12,13,14 should be connected to the LED bar graph
	// Pins 15,1,4,5 should be connected to DIP switches
	const char led[] = {9,7,0,2,3,12,13,14};
	const char sw[] = {15,1,4,5};

	int i, swval, numval, num;

	for(i=0; i<8; i++){
		pinMode(led[i], OUTPUT); // Configure the 8 LED pins as outputs
	}
	for(i=0; i<4; i++){
		pinMode(sw[i], INPUT); // Configure the 4 switch pins as inputs
	}

	while(1){
		for(i=0; i<4; i++){
			// Read each switch and write to the bottom 4 LEDs
			swval = digitalRead(sw[i]);
			printf("switch %d is %d\n", i, swval);
			digitalWrite(led[i], swval);
		}

		printf("Please enter a number from 0-15: ");
		scanf("%d", &num);
		for(i=0; i<4; i++){
			// Write the input number to the top 4 LEDs
			numval = (num >> i) & 0x01;
			digitalWrite(led[i+4], numval);
		}
		delay(3000); // Wait 3 seconds
	}

	return 0;
}