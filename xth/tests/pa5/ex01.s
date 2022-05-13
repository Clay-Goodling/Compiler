	.intel_syntax noprefix
	.text 
	.globl _Imain_paai
	.type _Imain_paai, @function
_Imain_paai:
	push rbp
	push r12
	push r13
	mov rbp, rsp
	sub rsp, 448
	mov r10, rdi
	mov QWORD PTR [rbp - 8], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 16], r10
	mov r10, 120
	mov QWORD PTR [rbp - 24], r10
	mov r12, QWORD PTR [rbp - 24]
	mov r10, r12
	mov QWORD PTR [rbp - 32], r10
	mov r12, QWORD PTR [rbp - 32]
	mov rdi, r12
	call _xi_alloc
	mov r10, rax
	mov QWORD PTR [rbp - 40], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 48], r10
	mov r12, QWORD PTR [rbp - 48]
	mov r10, r12
	mov QWORD PTR [rbp - 56], r10
	mov r10, 14
	mov QWORD PTR [rbp - 64], r10
	mov r10, QWORD PTR [rbp - 56]
	mov r12, QWORD PTR [rbp - 64]
	mov QWORD PTR [r10], r12
	mov r10, 72
	mov QWORD PTR [rbp - 72], r10
	mov r10, 8
	mov QWORD PTR [rbp - 80], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 88], r10
	mov r10, QWORD PTR [rbp - 88]
	mov r12, QWORD PTR [rbp - 80]
	add r10, r12
	mov QWORD PTR [rbp - 88], r10
	mov r10, QWORD PTR [rbp - 88]
	mov r12, QWORD PTR [rbp - 72]
	mov QWORD PTR [r10], r12
	mov r10, 101
	mov QWORD PTR [rbp - 96], r10
	mov r10, 16
	mov QWORD PTR [rbp - 104], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 112], r10
	mov r10, QWORD PTR [rbp - 112]
	mov r12, QWORD PTR [rbp - 104]
	add r10, r12
	mov QWORD PTR [rbp - 112], r10
	mov r10, QWORD PTR [rbp - 112]
	mov r12, QWORD PTR [rbp - 96]
	mov QWORD PTR [r10], r12
	mov r10, 108
	mov QWORD PTR [rbp - 120], r10
	mov r10, 24
	mov QWORD PTR [rbp - 128], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 136], r10
	mov r10, QWORD PTR [rbp - 136]
	mov r12, QWORD PTR [rbp - 128]
	add r10, r12
	mov QWORD PTR [rbp - 136], r10
	mov r10, QWORD PTR [rbp - 136]
	mov r12, QWORD PTR [rbp - 120]
	mov QWORD PTR [r10], r12
	mov r10, 108
	mov QWORD PTR [rbp - 144], r10
	mov r10, 32
	mov QWORD PTR [rbp - 152], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 160], r10
	mov r10, QWORD PTR [rbp - 160]
	mov r12, QWORD PTR [rbp - 152]
	add r10, r12
	mov QWORD PTR [rbp - 160], r10
	mov r10, QWORD PTR [rbp - 160]
	mov r12, QWORD PTR [rbp - 144]
	mov QWORD PTR [r10], r12
	mov r10, 111
	mov QWORD PTR [rbp - 168], r10
	mov r10, 40
	mov QWORD PTR [rbp - 176], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 184], r10
	mov r10, QWORD PTR [rbp - 184]
	mov r12, QWORD PTR [rbp - 176]
	add r10, r12
	mov QWORD PTR [rbp - 184], r10
	mov r10, QWORD PTR [rbp - 184]
	mov r12, QWORD PTR [rbp - 168]
	mov QWORD PTR [r10], r12
	mov r10, 44
	mov QWORD PTR [rbp - 192], r10
	mov r10, 48
	mov QWORD PTR [rbp - 200], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 208], r10
	mov r10, QWORD PTR [rbp - 208]
	mov r12, QWORD PTR [rbp - 200]
	add r10, r12
	mov QWORD PTR [rbp - 208], r10
	mov r10, QWORD PTR [rbp - 208]
	mov r12, QWORD PTR [rbp - 192]
	mov QWORD PTR [r10], r12
	mov r10, 32
	mov QWORD PTR [rbp - 216], r10
	mov r10, 56
	mov QWORD PTR [rbp - 224], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 232], r10
	mov r10, QWORD PTR [rbp - 232]
	mov r12, QWORD PTR [rbp - 224]
	add r10, r12
	mov QWORD PTR [rbp - 232], r10
	mov r10, QWORD PTR [rbp - 232]
	mov r12, QWORD PTR [rbp - 216]
	mov QWORD PTR [r10], r12
	mov r10, 87
	mov QWORD PTR [rbp - 240], r10
	mov r10, 64
	mov QWORD PTR [rbp - 248], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 256], r10
	mov r10, QWORD PTR [rbp - 256]
	mov r12, QWORD PTR [rbp - 248]
	add r10, r12
	mov QWORD PTR [rbp - 256], r10
	mov r10, QWORD PTR [rbp - 256]
	mov r12, QWORD PTR [rbp - 240]
	mov QWORD PTR [r10], r12
	mov r10, 111
	mov QWORD PTR [rbp - 264], r10
	mov r10, 72
	mov QWORD PTR [rbp - 272], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 280], r10
	mov r10, QWORD PTR [rbp - 280]
	mov r12, QWORD PTR [rbp - 272]
	add r10, r12
	mov QWORD PTR [rbp - 280], r10
	mov r10, QWORD PTR [rbp - 280]
	mov r12, QWORD PTR [rbp - 264]
	mov QWORD PTR [r10], r12
	mov r10, 114
	mov QWORD PTR [rbp - 288], r10
	mov r10, 80
	mov QWORD PTR [rbp - 296], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 304], r10
	mov r10, QWORD PTR [rbp - 304]
	mov r12, QWORD PTR [rbp - 296]
	add r10, r12
	mov QWORD PTR [rbp - 304], r10
	mov r10, QWORD PTR [rbp - 304]
	mov r12, QWORD PTR [rbp - 288]
	mov QWORD PTR [r10], r12
	mov r10, 108
	mov QWORD PTR [rbp - 312], r10
	mov r10, 88
	mov QWORD PTR [rbp - 320], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 328], r10
	mov r10, QWORD PTR [rbp - 328]
	mov r12, QWORD PTR [rbp - 320]
	add r10, r12
	mov QWORD PTR [rbp - 328], r10
	mov r10, QWORD PTR [rbp - 328]
	mov r12, QWORD PTR [rbp - 312]
	mov QWORD PTR [r10], r12
	mov r10, 100
	mov QWORD PTR [rbp - 336], r10
	mov r10, 96
	mov QWORD PTR [rbp - 344], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 352], r10
	mov r10, QWORD PTR [rbp - 352]
	mov r12, QWORD PTR [rbp - 344]
	add r10, r12
	mov QWORD PTR [rbp - 352], r10
	mov r10, QWORD PTR [rbp - 352]
	mov r12, QWORD PTR [rbp - 336]
	mov QWORD PTR [r10], r12
	mov r10, 33
	mov QWORD PTR [rbp - 360], r10
	mov r10, 104
	mov QWORD PTR [rbp - 368], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 376], r10
	mov r10, QWORD PTR [rbp - 376]
	mov r12, QWORD PTR [rbp - 368]
	add r10, r12
	mov QWORD PTR [rbp - 376], r10
	mov r10, QWORD PTR [rbp - 376]
	mov r12, QWORD PTR [rbp - 360]
	mov QWORD PTR [r10], r12
	mov r10, 10
	mov QWORD PTR [rbp - 384], r10
	mov r10, 112
	mov QWORD PTR [rbp - 392], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 400], r10
	mov r10, QWORD PTR [rbp - 400]
	mov r12, QWORD PTR [rbp - 392]
	add r10, r12
	mov QWORD PTR [rbp - 400], r10
	mov r10, QWORD PTR [rbp - 400]
	mov r12, QWORD PTR [rbp - 384]
	mov QWORD PTR [r10], r12
	mov r10, 8
	mov QWORD PTR [rbp - 408], r10
	mov r12, QWORD PTR [rbp - 56]
	mov r10, r12
	mov QWORD PTR [rbp - 416], r10
	mov r10, QWORD PTR [rbp - 416]
	mov r12, QWORD PTR [rbp - 408]
	add r10, r12
	mov QWORD PTR [rbp - 416], r10
	mov r12, QWORD PTR [rbp - 416]
	mov r10, r12
	mov QWORD PTR [rbp - 424], r10
	mov r12, QWORD PTR [rbp - 424]
	mov rdi, r12
	call _Iprint_pai
	mov r10, 167
	mov QWORD PTR [rbp - 432], r10
	mov r12, QWORD PTR [rbp - 432]
	mov r10, r12
	mov QWORD PTR [rbp - 440], r10
	mov r12, QWORD PTR [rbp - 440]
	mov r10, r12
	mov QWORD PTR [rbp - 448], r10
	mov rsp, rbp
	pop r13
	pop r12
	pop rbp
	ret
	.size _Imain_paai, .-_Imain_paai
