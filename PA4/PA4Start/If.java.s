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
# If Statement

	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24
	ldi 	r25, 0
	cp 	r24, r25
	breq   MJ_L7
	jmp  MJ_L6

MJ_L7:
	pop 	r24
	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24

MJ_L6:
	pop 	r24
	ldi 	r25, 0

	cp 	r24, r25
	brne  MJ_L4
	jmp  MJ_L3

MJ_L4:
	jmp   MJ_L5

MJ_L3:
#Done

MJ_L5:

# Load condition and branch iff false 
 # load a one byte exp off stack
	pop 	r24
	#Load zero into reg
	ldi 	r25, 0

 #use cp to set SREG
	cp 	r24, r25
	#WANT breq to someMJ_L0
	brne 	MJ_L1
	jmp 	MJ_L0


#Then label for if
MJ_L1:




	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


	push	r25


	push	r24


	ldi	r24, lo8(6)

	ldi	r25, hi8(6)


	push	r25


	push	r24

	pop 	r18
	pop 	r19

	pop 	r24
	pop 	r25


	add 	r24, r18
	adc 	r25, r19

	push 	r25
	push 	r24


	pop 	r24
	pop 	r25
	push 	r24


#sub
	sub 	r24, r18
	sbc 	r25, r19

	push 	r25
	push 	r24
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


	jmp 	MJ_L2


	# else label for ifMJ_L0:


MJ_L0:


	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


	push	r25


	push	r24

	#negation
	pop 	r24
	pop 	r25
	ldi 	r22, 0
	ldi 	r23, 0
	sub 	r22, r24
	sbc 	r23, r25
	push 	r23
	push 	r22

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(7)

	ldi	r25, hi8(7)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	#negation
	pop 	r24
	pop 	r25
	ldi 	r22, 0
	ldi 	r23, 0
	sub 	r22, r24
	sbc 	r23, r25
	push 	r23
	push 	r22

	pop 	r24
	pop 	r25
	push 	r24


#mult starting
	pop 	r18
	pop 	r22
	mov 	r24, r18
	mov 	r26, r22
	muls 	r24, r26
	push 	r1
	push 	r0
	eor 	r0, r0
	eor 	r1, r1

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(6)

	ldi	r25, hi8(6)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	ldi 	r22, 1
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


MJ_L2:




/* epilogue start */
    endLabel:
    jmp endLabel
    ret
    .size   main, .-main

