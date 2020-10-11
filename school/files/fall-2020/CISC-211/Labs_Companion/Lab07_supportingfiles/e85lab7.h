/*	e85lab7.h
 *		Created: 		14 November 2013
 *						Sarah_Lichtman@hmc.edu
 *		Last Modified: 	15 November 2013
 *						Sarah_Lichtman@hmc.edu
 *						
 *	Helper code for E85 lab 7: Temperature Control.
 *	Using wiringPi SPI functions, read the output of the 10-bit MCP3002 ADC.
 */

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>

#include <wiringPiSPI.h>

uint8_t buf[2];
#define CHANNEL 0

void initAnalogSPI(){
	if (wiringPiSPISetup(CHANNEL, 4000000) < 0) {
            fprintf (stderr, "SPI Setup failed: %s\n", strerror (errno));
            exit(errno);
    }
}

unsigned int analogReadSPI() {
	buf[0] = 0x60;
	buf[1] = 0x00;
	wiringPiSPIDataRW(CHANNEL, buf, 2);
	return buf[1] + ((buf[0] & 0x03) << 8);
}
