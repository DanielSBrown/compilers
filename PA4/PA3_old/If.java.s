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
	breq   ML_3
	jmp  ML_2

ML_3:
	pop 	r24
	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24

ML_2:
	pop 	r24
	ldi 	r25, 0

	cp 	r24, r25
	brne  ML_0
	jmp  ML_0

ML_0:
	jmp   ML_1

ML_0:
#Done

ML_1:


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



	ldi	r24, lo8(5)

	ldi	r25, hi8(5)


	push	r25


	push	r24


	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


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


	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


	push	r25


	push	r24

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


	pop 	r24
	pop 	r25
	push 	r24


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



/* epilogue start */
    endLabel:
    jmp endLabel
    ret
    .size   main, .-main

