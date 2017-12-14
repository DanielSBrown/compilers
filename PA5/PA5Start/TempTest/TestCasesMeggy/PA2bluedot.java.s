
	ldi	r24, lo8(1)

	ldi	r25, hi8(1)


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


	ldi 	r22, 5
	push 	r22
	pop r20
	pop r22
	pop r24
	call 	_Z6DrawPxhhh
	call 	_Z12DisplaySlatev

