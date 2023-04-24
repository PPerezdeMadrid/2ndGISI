
.text
main:
	li $v0,5
	syscall
	move $t0,$v0

	li $v0,5
	syscall
	move $t1,$v0

	bgt $t0,$t1,L1
	move $t2,$t1
	j L2
	
	L1:
		move $t2,$t0
	L2: 
		move $a0,$t2
		li $v0,1
		syscall

		li $v0,10
syscall


