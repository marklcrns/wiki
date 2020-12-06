@ Assignment 6.14
@
@ Mark Lucernas
@
@ To run this code on a RaspberryPi (if the filename is filename.s) do the following
@       as -o filename.o filename.s
@       gcc -o filename filename.o
@       ./filename

.text
.global main
.extern printf
main: 
	@ push return address (lr) and ip on the stack
	push	{ip, lr}


	@ R0 and R1 are the input, and they initially contain positive numbers, a and b (for example 9 and 2). 
	@ At the end of the program, R0 is the output.

	MOV R0, #9	@ move number 9 into register R0
	MOV R1, #2	@ move number 2 into register R1

@ Insert the ARM Assembly code for the following machine language:
@         0x00008008 0xE3A02000
@         0x0000800C 0xE1A03001
@         0x00008010 0xE1510000
@         0x00008014 0x8A000002
@         0x00008018 0xE2822001
@         0x0000801C 0xE0811003
@         0x00008020 0xEAFFFFFA
@ after the following two lines:
@---------------------

	MOV R2, #0	@ i = 0
	MOV R3, R1	@ R3 = R1 (divisor)
L1:
	CMP R1, R0	@ i < R0 (dividend)
	BHI DONE	@ if i >= R0 exit loop
	ADD R2, R2, #1	@ R2 = R2 + 1
	ADD R1, R1, R3	@ R1 = R2 + R3
	B   L1		@ repeat loop
DONE:
	MOV R0, R2	@ R0 = R2

@ end of ARM Assembly code for the above machine language ends here.
@---------------------
@
@ the following code prints the content 

	MOV R1, R0
	LDR R0, =fmt	@ load fmt (output format) 
	BL printf

	@ pop the values from stack into ip and pc registers
	pop	{ip, pc}

.data
fmt:	.asciz "\nThis code produces the following Result: %d\n"



