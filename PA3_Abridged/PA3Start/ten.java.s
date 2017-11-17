    .file  "main.java"
__SREG__ = 0x3f
__SP_H__ = 0x3e
__SP_L__ = 0x3d
__tmp_reg__ = 0
__zero_reg__ = 1
    .global __do_copy_data
    .global __do_clear_bss
    .text
.global main
    .type   main, @function
main:
    push r29
    push r28
    in r28,__SP_L__
    in r29,__SP_H__
/* prologue: function */
    call _Z18MeggyJrSimpleSetupv 
    /* Need to call this so that the meggy library gets set up */
# While Statement

MJ_L0:


	ldi	r24, lo8(2)

	ldi	r25, hi8(2)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(2)

	ldi	r25, hi8(2)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


# Checking Equals
	pop 	r18

	pop 	r24
	cp 	r24, r18
	breq MJ_L4


 		 #result is false
MJ_L3:
	ldi 	r24, 0
	jmp 	MJ_L5

	# Result is true
MJ_L4:
	ldi 	r24, 1
MJ_L5:
	 # Push one byte expression onto stack
	push 	r24

 	# if not (condition) WHILE
	pop 	 r24
	ldi 	 r25, 0
	cp 	r24, r25
	# WANT breq MJ_L2
	brne 	MJ_L1
	jmp 	MJ_L2


MJ_L1:


	ldi	r24, lo8(2)

	ldi	r25, hi8(2)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(2)

	ldi	r25, hi8(2)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	ldi 	r22, 4
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


 	jmp 	MJ_L0


 	# end of while
MJ_L2:



/* epilogue start */
    endLabel:
    jmp endLabel
    ret
    .size   main, .-main

