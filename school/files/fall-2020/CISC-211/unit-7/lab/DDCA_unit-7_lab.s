@ Unit 7 Lab
@ Mark Lucernas
@ --------------------------------------------------------------------------------
@ 	Data Section
@ --------------------------------------------------------------------------------
	.data
	.balign 4
output:	.asciz	"%d\n"		@ Output format
arr:	.skip	40		@ Allocate 10 int (4 bytes, 10 * 4 = 40)

@ --------------------------------------------------------------------------------
@ 	Code Section
@ --------------------------------------------------------------------------------
	.text
	.global main
	.extern printf

main: 	push {ip, lr} 			@ push return address (lr) + dummy register (ip)
					@ on the stack
	LDR R5, =arr 			@ R5 <- &arr (array base address)
	MOV R6, #0			@ R6 <- 0, i = 0 (index)
	MOV R7, #10			@ R7 <- 10 (array length)

@ First Loop: Initialize the array with numbers 0 - 9
@ --------------------------------------------------------------------------------
LOOP1:
	CMP R6, R7			@ R6, i < 10?
	BEQ END1			@ Exit loop if R6, i >= 10
	STR R6, [R5, R6, LSL #2]	@ *R6 -> &arr * R6 * 4
	ADD R6, R6, #1			@ R6 <- *R6 + 1, Increment loop
	B LOOP1 			@ repeat loop
END1:

@ Second Loop: Add 10 to each of the values in the array
@ --------------------------------------------------------------------------------
	MOV R6, #0			@ Reset R6, i = 0
LOOP2:
	CMP R6, R7			@ R6, i < 10?
	BEQ END2			@ if i >= 10, exit loop
	LSL R8, R6, #2			@ R8 <- *R6 (i) * 4
	LDR R9, [R5, R8]		@ R9 <- &arr * R8 (i * 4)
	ADD R9, R9, #10			@ R9 <- *R9 + 10
	STR R9, [R5, R8]		@ *R9 -> &arr * R8
	ADD R6, R6, #1			@ R6 = *R6 (i) + 1
	B LOOP2 			@ repeat loop
END2:

@ Third Loop: Prints the contents of the array
@ --------------------------------------------------------------------------------
	MOV R6, #0			@ Reset R6, i = 0
LOOP3:
	LDR R5, =arr 			@ Restore R5 <- &arr
	CMP R6, R7			@ i < 10?
	BEQ END3			@ if i >= 10, exit loop

	LDR R0, [R5, R6, LSL #2]	@ R0 <- *(arr * R6 * 4)

	MOV R1, R0
	LDR R0, =output			@ Load output
	BL printf
	ADD R6, R6, #1			@ R6 = R6 (i) + 1
	B LOOP3 			@ repeat loop
END3:

exit:	pop {ip, pc} 			@ pop the values from stack into ip and pc registers


