	.intel_syntax noprefix
	.text 
	.globl _Igcd_iii
	.type _Igcd_iii, @function
_Igcd_iii:
	push rbp
	push r12
	push r13
	push r14
	push r15
	push rbx
	mov rbp, rsp
	sub rsp, 8
	mov r14, rdi
	mov r10, rsi
	mov QWORD PTR [rbp - 8], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 8], r10
._label2:
	mov r13, 1
	mov rbx, 0
	mov r15, 1
	cmp r14, rbx
	jne .L0
	mov r15, 0
.L0:
	xor r13, r15
	cmp r13, 0
	jne ._label3
	mov r13, 1
	mov r12, QWORD PTR [rbp - 8]
	cmp r14, r12
	jl .L2
	mov r13, 0
.L2:
	cmp r13, 0
	jne ._label0
	mov r12, QWORD PTR [rbp - 8]
	sub r14, r12
	jmp ._label1
._label0:
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 8], r10
	mov r10, QWORD PTR [rbp - 8]
	sub r10, r14
	mov QWORD PTR [rbp - 8], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 8], r10
._label1:
	jmp ._label2
._label3:
	mov r12, QWORD PTR [rbp - 8]
	mov rax, r12
	mov rsp, rbp
	pop rbx
	pop r15
	pop r14
	pop r13
	pop r12
	pop rbp
	ret
	.size _Igcd_iii, .-_Igcd_iii
	.text 
	.globl _Iisprime_bi
	.type _Iisprime_bi, @function
_Iisprime_bi:
	push rbp
	push r12
	push r13
	push r14
	push r15
	push rbx
	mov rbp, rsp
	sub rsp, 8
	mov r10, rdi
	mov QWORD PTR [rbp - 8], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 8], r10
	mov r14, 2
._label7:
	mov rbx, 1
	mov r15, r14
	imul r15, r14
	mov r13, 1
	mov r12, QWORD PTR [rbp - 8]
	cmp r15, r12
	jle .L6
	mov r13, 0
.L6:
	xor rbx, r13
	cmp rbx, 0
	jne ._label8
	mov r15, r14
	mov r12, QWORD PTR [rbp - 8]
	mov r13, r12
	mov rdi, r15
	mov rsi, r13
	call _Igcd_iii
	mov r13, rax
	mov r15, 1
	mov rbx, 1
	cmp r13, r15
	jne .L8
	mov rbx, 0
.L8:
	cmp rbx, 0
	jne ._label5
._label4:
	jmp ._label6
._label5:
	mov r13, 0
	mov rax, r13
	mov rsp, rbp
	pop rbx
	pop r15
	pop r14
	pop r13
	pop r12
	pop rbp
	ret
._label6:
	mov r13, 1
	add r14, r13
	jmp ._label7
._label8:
	mov r13, 1
	mov rax, r13
	mov rsp, rbp
	pop rbx
	pop r15
	pop r14
	pop r13
	pop r12
	pop rbp
	ret
	.size _Iisprime_bi, .-_Iisprime_bi
	.text 
	.globl _Ilargestprime_ii
	.type _Ilargestprime_ii, @function
_Ilargestprime_ii:
	push rbp
	push r12
	push r13
	push r14
	push r15
	push rbx
	mov rbp, rsp
	sub rsp, 8
	mov r10, rdi
	mov QWORD PTR [rbp - 8], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 8], r10
	mov r15, 1
	mov r13, 1
._label12:
	mov rbx, 1
	mov r14, 1
	mov r12, QWORD PTR [rbp - 8]
	cmp r15, r12
	jl .L10
	mov r14, 0
.L10:
	xor rbx, r14
	cmp rbx, 0
	jne ._label13
	mov r14, r15
	mov rdi, r14
	call _Iisprime_bi
	mov r14, rax
	cmp r14, 0
	jne ._label10
._label9:
	jmp ._label11
._label10:
	mov r13, r15
._label11:
	mov r14, 1
	add r15, r14
	jmp ._label12
._label13:
	mov rax, r13
	mov rsp, rbp
	pop rbx
	pop r15
	pop r14
	pop r13
	pop r12
	pop rbp
	ret
	.size _Ilargestprime_ii, .-_Ilargestprime_ii
	.text 
	.globl _Imain_paai
	.type _Imain_paai, @function
_Imain_paai:
	push rbp
	push r12
	push r13
	push r14
	push r15
	push rbx
	mov rbp, rsp
	sub rsp, 48
	mov r13, 280
	mov rdi, r13
	call _xi_alloc
	mov r15, rax
	mov r10, r15
	mov QWORD PTR [rbp - 48], r10
	mov r12, QWORD PTR [rbp - 48]
	mov r10, r12
	mov QWORD PTR [rbp - 48], r10
	mov r13, 34
	mov r10, QWORD PTR [rbp - 48]
	mov QWORD PTR [r10], r13
	mov r14, 8
	mov r12, QWORD PTR [rbp - 48]
	mov r13, r12
	add r13, r14
	mov r14, 76
	mov QWORD PTR [r13], r14
	mov rbx, 97
	mov r14, 16
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, r14
	mov QWORD PTR [r15], rbx
	mov rbx, 114
	mov r15, 24
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, r15
	mov QWORD PTR [r14], rbx
	mov r14, 103
	mov rbx, 32
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, rbx
	mov QWORD PTR [r15], r14
	mov r14, 101
	mov r15, 40
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov rbx, 115
	mov r15, 48
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, r15
	mov QWORD PTR [r14], rbx
	mov rbx, 116
	mov r14, 56
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, r14
	mov QWORD PTR [r15], rbx
	mov rbx, 32
	mov r15, 64
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, r15
	mov QWORD PTR [r14], rbx
	mov r14, 112
	mov r15, 72
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r14, 114
	mov r15, 80
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r14, 105
	mov r15, 88
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r15, 109
	mov r14, 96
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r14
	mov QWORD PTR [rbx], r15
	mov r14, 101
	mov r15, 104
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r14, 32
	mov rbx, 112
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, rbx
	mov QWORD PTR [r15], r14
	mov rbx, 108
	mov r14, 120
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, r14
	mov QWORD PTR [r15], rbx
	mov r14, 101
	mov r15, 128
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r15, 115
	mov rbx, 136
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, rbx
	mov QWORD PTR [r14], r15
	mov rbx, 115
	mov r14, 144
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, r14
	mov QWORD PTR [r15], rbx
	mov r14, 32
	mov rbx, 152
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, rbx
	mov QWORD PTR [r15], r14
	mov r15, 116
	mov r14, 160
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r14
	mov QWORD PTR [rbx], r15
	mov rbx, 104
	mov r15, 168
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, r15
	mov QWORD PTR [r14], rbx
	mov r14, 97
	mov r15, 176
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov rbx, 110
	mov r14, 184
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, r14
	mov QWORD PTR [r15], rbx
	mov r14, 32
	mov r15, 192
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r15, 50
	mov rbx, 200
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, rbx
	mov QWORD PTR [r14], r15
	mov r14, 48
	mov r15, 208
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov rbx, 44
	mov r15, 216
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, r15
	mov QWORD PTR [r14], rbx
	mov r14, 48
	mov r15, 224
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov rbx, 48
	mov r15, 232
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, r15
	mov QWORD PTR [r14], rbx
	mov r14, 48
	mov r15, 240
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r14, 32
	mov rbx, 248
	mov r12, QWORD PTR [rbp - 48]
	mov r15, r12
	add r15, rbx
	mov QWORD PTR [r15], r14
	mov r14, 105
	mov r15, 256
	mov r12, QWORD PTR [rbp - 48]
	mov rbx, r12
	add rbx, r15
	mov QWORD PTR [rbx], r14
	mov r15, 115
	mov rbx, 264
	mov r12, QWORD PTR [rbp - 48]
	mov r14, r12
	add r14, rbx
	mov QWORD PTR [r14], r15
	mov r14, 32
	mov r15, 272
	mov r12, QWORD PTR [rbp - 48]
	mov r10, r12
	mov QWORD PTR [rbp - 48], r10
	mov r10, QWORD PTR [rbp - 48]
	add r10, r15
	mov QWORD PTR [rbp - 48], r10
	mov r10, QWORD PTR [rbp - 48]
	mov QWORD PTR [r10], r14
	mov r14, 20000
	mov rdi, r14
	call _Ilargestprime_ii
	mov r15, rax
	mov r14, r15
	mov rdi, r14
	call _IunparseInt_aii
	mov r15, rax
	mov r14, r15
	mov r10, r14
	mov QWORD PTR [rbp - 40], r10
	mov r15, 8
	mov r14, r13
	sub r14, r15
	mov r14, QWORD PTR [r14]
	mov r15, 8
	mov r12, QWORD PTR [rbp - 40]
	mov rbx, r12
	sub rbx, r15
	mov rbx, QWORD PTR [rbx]
	mov r15, r14
	add r15, rbx
	mov r10, r15
	mov QWORD PTR [rbp - 32], r10
	mov r15, 8
	mov r12, QWORD PTR [rbp - 32]
	mov rbx, r12
	imul rbx, r15
	mov r15, 8
	add rbx, r15
	mov r15, rbx
	mov rdi, r15
	call _xi_alloc
	mov r15, rax
	mov rbx, r15
	mov r12, QWORD PTR [rbp - 32]
	mov QWORD PTR [rbx], r12
	mov r15, 8
	add rbx, r15
	mov r10, rbx
	mov QWORD PTR [rbp - 24], r10
	mov r15, 0
	mov r10, r15
	mov QWORD PTR [rbp - 16], r10
._label14:
	mov r15, 1
	mov r10, QWORD PTR [rbp - 16]
	cmp r10, r14
	jge .L53
	mov r15, 0
.L53:
	cmp r15, 0
	jne ._label15
	mov rbx, 8
	mov r12, QWORD PTR [rbp - 16]
	imul rbx, r12
	mov r15, r13
	add r15, rbx
	mov r10, QWORD PTR [r15]
	mov QWORD PTR [rbp - 8], r10
	mov rbx, 8
	mov r12, QWORD PTR [rbp - 16]
	imul rbx, r12
	mov r12, QWORD PTR [rbp - 24]
	mov r15, r12
	add r15, rbx
	mov r12, QWORD PTR [rbp - 8]
	mov QWORD PTR [r15], r12
	mov r15, 1
	mov r12, QWORD PTR [rbp - 16]
	mov rbx, r12
	add rbx, r15
	mov r10, rbx
	mov QWORD PTR [rbp - 16], r10
	jmp ._label14
._label15:
	mov r13, 1
	mov r10, QWORD PTR [rbp - 16]
	mov r12, QWORD PTR [rbp - 32]
	cmp r10, r12
	je .L59
	mov r13, 0
.L59:
	cmp r13, 0
	jne ._label16
	mov r15, 8
	mov r12, QWORD PTR [rbp - 16]
	mov r13, r12
	sub r13, r14
	imul r15, r13
	mov r12, QWORD PTR [rbp - 40]
	mov r13, r12
	add r13, r15
	mov r15, QWORD PTR [r13]
	mov rbx, 8
	mov r12, QWORD PTR [rbp - 16]
	imul rbx, r12
	mov r12, QWORD PTR [rbp - 24]
	mov r13, r12
	add r13, rbx
	mov QWORD PTR [r13], r15
	mov r13, 1
	mov r12, QWORD PTR [rbp - 16]
	mov r15, r12
	add r15, r13
	mov r10, r15
	mov QWORD PTR [rbp - 16], r10
	jmp ._label15
._label16:
	mov r12, QWORD PTR [rbp - 24]
	mov r13, r12
	mov rdi, r13
	call _Iprint_pai
	mov rsp, rbp
	pop rbx
	pop r15
	pop r14
	pop r13
	pop r12
	pop rbp
	ret
	.size _Imain_paai, .-_Imain_paai
