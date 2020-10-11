/************* CODE SECTION *************/
@Name Here
.text   @ the following is executable assembly

@ Ensure code section is 4-byte aligned:
.balign 4

@ main is the entry point and must be global
.global main
B main          @ begin at main

/************* MAIN SECTION *************/
MAIN:
	MOV  R0, #13		@ n = 13
	MOV  R1, #1			@ old = 1
	MOV  R2, #0			@ cur = 0
LOOP:
	B   LOOP			@ infinite loop
DONE:	
	BX  LR			@ exit cleanly

.end     @ end of code

