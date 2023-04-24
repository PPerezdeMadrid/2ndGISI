.text
 .globl main
main:
      li $v0,4
      la $a0, prompt
      syscall
      li $v0,1
      lb $a0, val
      syscall
      addi $t0, $t0, 1
#syscall to print a string #address of string to print #print the string
#syscall to print an integer #load the integer to print to $a0 #print it
#increment the value of $t0 #sys call for exit
      li $v0,-100
      syscall
.data
10
prompt: val:
.asciiz "your code is:"
.byte 8
