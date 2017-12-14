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


 	# if not (condition) WHILE
	pop 	 r24
	ldi 	 r25, 0
	cp 	r24, r25
	# WANT breq MJ_L2
	brne 	MJ_L1
	jmp 	MJ_L2


MJ_L1:


	ldi	r24, lo8(1000)

	ldi	r25, hi8(1000)


	push	r25


	push	r24


	pop 	r24
	pop 	r25
	call   _Z8delay_msj

# If Statement

	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24
	ldi 	r25, 0
	cp 	r24, r25
	breq   MJ_L10
	jmp  MJ_L9

MJ_L10:
	pop 	r24
	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24

MJ_L9:
	pop 	r24
	ldi 	r25, 0

	cp 	r24, r25
	brne  MJ_L7
	jmp  MJ_L6

MJ_L7:
	jmp   MJ_L8

MJ_L6:
#Done

MJ_L8:

# Load condition and branch iff false 
 # load a one byte exp off stack
	pop 	r24
	#Load zero into reg
	ldi 	r25, 0

 #use cp to set SREG
	cp 	r24, r25
	#WANT breq to someMJ_L3
	brne 	MJ_L4
	jmp 	MJ_L3


#Then label for if
MJ_L4:




	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


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


# assign statement
	pop 	r24

	std base1 + 0, r24


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(4)

	ldi	r25, hi8(4)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	jmp 	MJ_L5


	# else label for ifMJ_L3:


MJ_L3:

# If Statement

	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24
	ldi 	r25, 0
	cp 	r24, r25
	breq   MJ_L18
	jmp  MJ_L17

MJ_L18:
	pop 	r24
	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24

MJ_L17:
	pop 	r24
	ldi 	r25, 0

	cp 	r24, r25
	brne  MJ_L15
	jmp  MJ_L14

MJ_L15:
	jmp   MJ_L16

MJ_L14:
#Done

MJ_L16:

# Load condition and branch iff false 
 # load a one byte exp off stack
	pop 	r24
	#Load zero into reg
	ldi 	r25, 0

 #use cp to set SREG
	cp 	r24, r25
	#WANT breq to someMJ_L11
	brne 	MJ_L12
	jmp 	MJ_L11


#Then label for if
MJ_L12:




	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(4)

	ldi	r25, hi8(4)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


# assign statement
	pop 	r24

	std base1 + 0, r24


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


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


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	jmp 	MJ_L13


	# else label for ifMJ_L11:


MJ_L11:

# If Statement

	#CheckButton
	call    _Z16CheckButtonsDownv
	lds 	r24, Button_Up
	tst 	r24
	breqML_22

# Load condition and branch iff false 
 # load a one byte exp off stack
	pop 	r24
	#Load zero into reg
	ldi 	r25, 0

 #use cp to set SREG
	cp 	r24, r25
	#WANT breq to someMJ_L19
	brne 	MJ_L20
	jmp 	MJ_L19


#Then label for if
MJ_L20:




	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


# assign statement
	pop 	r24

	std base1 + 0, r24


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



	ldi	r24, lo8(4)

	ldi	r25, hi8(4)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


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


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	jmp 	MJ_L21


	# else label for ifMJ_L19:


MJ_L19:


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24



MJ_L21:



MJ_L13:



MJ_L5:



 	jmp 	MJ_L0


 	# end of while
MJ_L2:

#sub
	sub 	r24, r18
	sbc 	r25, r19

	push 	r25
	push 	r24
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


	ldi	r24, lo8(0)

	ldi	r25, hi8(0)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


# assign statement
	pop 	r24

	std base1 + 0, r24

# While Statement

MJ_L23:

	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24
	ldi 	r25, 0
	cp 	r24, r25
	breq   MJ_L30
	jmp  MJ_L29

MJ_L30:
	pop 	r24
	ldi 	r22, 1
	push 	r22
	pop 	r24
	push 	r24

MJ_L29:
	pop 	r24
	ldi 	r25, 0

	cp 	r24, r25
	brne  MJ_L27
	jmp  MJ_L26

MJ_L27:
	jmp   MJ_L28

MJ_L26:
#Done

MJ_L28:


 	# if not (condition) WHILE
	pop 	 r24
	ldi 	 r25, 0
	cp 	r24, r25
	# WANT breq MJ_L25
	brne 	MJ_L24
	jmp 	MJ_L25


MJ_L24:

#sub
	sub 	r24, r18
	sbc 	r25, r19

	push 	r25
	push 	r24
	pop 	r24
	pop 	r25
	push 	r24


# assign statement
	pop 	r24

	std base1 + 0, r24


	ldi	r24, lo8(256)

	ldi	r25, hi8(256)


	push	r25


	push	r24


	pop 	r24
	pop 	r25
	call   _Z8delay_msj

# If Statement


	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


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



	ldi	r24, lo8(8)

	ldi	r25, hi8(8)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	# lt expression
	pop 	r18
	pop 	r24
	cp r24, r18
	brlt MJ_L35


#Load false
MJ_L34:
	ldi 	r24, 0
	jmp MJ_L36

# load true
MJ_L35:
	ldi 	r24, 1

# push results of lt
MJ_L36:
	push 	r24

# Load condition and branch iff false 
 # load a one byte exp off stack
	pop 	r24
	#Load zero into reg
	ldi 	r25, 0

 #use cp to set SREG
	cp 	r24, r25
	#WANT breq to someMJ_L31
	brne 	MJ_L32
	jmp 	MJ_L31


#Then label for if
MJ_L32:




	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


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


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	jmp 	MJ_L33


	# else label for ifMJ_L31:


MJ_L31:


MJ_L33:


	ldi 	r22, 1
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


 	jmp 	MJ_L23


 	# end of while
MJ_L25:


	ldi	r24, lo8(7)

	ldi	r25, hi8(7)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


# assign statement
	pop 	r24

	std base1 + 0, r24

# While Statement

MJ_L37:


	ldi	r24, lo8(8)

	ldi	r25, hi8(8)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


	# lt expression
	pop 	r18
	pop 	r24
	cp r24, r18
	brlt MJ_L41


#Load false
MJ_L40:
	ldi 	r24, 0
	jmp MJ_L42

# load true
MJ_L41:
	ldi 	r24, 1

# push results of lt
MJ_L42:
	push 	r24


 	# if not (condition) WHILE
	pop 	 r24
	ldi 	 r25, 0
	cp 	r24, r25
	# WANT breq MJ_L39
	brne 	MJ_L38
	jmp 	MJ_L39


MJ_L38:


	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


	push	r25


	push	r24

	pop 	r24
	pop 	r25
	push 	r24


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


# assign statement
	pop 	r24

	std base1 + 0, r24


	ldi	r24, lo8(256)

	ldi	r25, hi8(256)


	push	r25


	push	r24


	pop 	r24
	pop 	r25
	call   _Z8delay_msj

# If Statement

#sub
	sub 	r24, r18
	sbc 	r25, r19

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


	# lt expression
	pop 	r18
	pop 	r24
	cp r24, r18
	brlt MJ_L47


#Load false
MJ_L46:
	ldi 	r24, 0
	jmp MJ_L48

# load true
MJ_L47:
	ldi 	r24, 1

# push results of lt
MJ_L48:
	push 	r24

# Load condition and branch iff false 
 # load a one byte exp off stack
	pop 	r24
	#Load zero into reg
	ldi 	r25, 0

 #use cp to set SREG
	cp 	r24, r25
	#WANT breq to someMJ_L43
	brne 	MJ_L44
	jmp 	MJ_L43


#Then label for if
MJ_L44:



#sub
	sub 	r24, r18
	sbc 	r25, r19

	push 	r25
	push 	r24
	pop 	r24
	pop 	r25
	push 	r24


	ldi 	r22, 0
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


	jmp 	MJ_L45


	# else label for ifMJ_L43:


MJ_L43:


MJ_L45:


	ldi 	r22, 1
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev


 	jmp 	MJ_L37


 	# end of while
MJ_L39:

# assign statement
	pop 	r24

	std base1 + 0, r24



/* epilogue start */
    endLabel:
    jmp endLabel
    ret
    .size   main, .-main

