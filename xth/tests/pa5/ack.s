	.intel_syntax noprefix
	.text 
	.globl _Iusage_p
	.type _Iusage_p, @function
_Iusage_p:
	push rbp
	push r12
	push r13
	mov rbp, rsp
	sub rsp, 768
	mov r10, 240
	mov QWORD PTR [rbp - 8], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 16], r10
	mov r12, QWORD PTR [rbp - 16]
	mov rdi, r12
	call _xi_alloc
	mov r10, rax
	mov QWORD PTR [rbp - 24], r10
	mov r12, QWORD PTR [rbp - 24]
	mov r10, r12
	mov QWORD PTR [rbp - 32], r10
	mov r12, QWORD PTR [rbp - 32]
	mov r10, r12
	mov QWORD PTR [rbp - 40], r10
	mov r10, 29
	mov QWORD PTR [rbp - 48], r10
	mov r10, QWORD PTR [rbp - 40]
	mov r12, QWORD PTR [rbp - 48]
	mov QWORD PTR [r10], r12
	mov r10, 80
	mov QWORD PTR [rbp - 56], r10
	mov r10, 8
	mov QWORD PTR [rbp - 64], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 72], r10
	mov r10, QWORD PTR [rbp - 72]
	mov r12, QWORD PTR [rbp - 64]
	add r10, r12
	mov QWORD PTR [rbp - 72], r10
	mov r10, QWORD PTR [rbp - 72]
	mov r12, QWORD PTR [rbp - 56]
	mov QWORD PTR [r10], r12
	mov r10, 108
	mov QWORD PTR [rbp - 80], r10
	mov r10, 16
	mov QWORD PTR [rbp - 88], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 96], r10
	mov r10, QWORD PTR [rbp - 96]
	mov r12, QWORD PTR [rbp - 88]
	add r10, r12
	mov QWORD PTR [rbp - 96], r10
	mov r10, QWORD PTR [rbp - 96]
	mov r12, QWORD PTR [rbp - 80]
	mov QWORD PTR [r10], r12
	mov r10, 101
	mov QWORD PTR [rbp - 104], r10
	mov r10, 24
	mov QWORD PTR [rbp - 112], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 120], r10
	mov r10, QWORD PTR [rbp - 120]
	mov r12, QWORD PTR [rbp - 112]
	add r10, r12
	mov QWORD PTR [rbp - 120], r10
	mov r10, QWORD PTR [rbp - 120]
	mov r12, QWORD PTR [rbp - 104]
	mov QWORD PTR [r10], r12
	mov r10, 97
	mov QWORD PTR [rbp - 128], r10
	mov r10, 32
	mov QWORD PTR [rbp - 136], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 144], r10
	mov r10, QWORD PTR [rbp - 144]
	mov r12, QWORD PTR [rbp - 136]
	add r10, r12
	mov QWORD PTR [rbp - 144], r10
	mov r10, QWORD PTR [rbp - 144]
	mov r12, QWORD PTR [rbp - 128]
	mov QWORD PTR [r10], r12
	mov r10, 115
	mov QWORD PTR [rbp - 152], r10
	mov r10, 40
	mov QWORD PTR [rbp - 160], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 168], r10
	mov r10, QWORD PTR [rbp - 168]
	mov r12, QWORD PTR [rbp - 160]
	add r10, r12
	mov QWORD PTR [rbp - 168], r10
	mov r10, QWORD PTR [rbp - 168]
	mov r12, QWORD PTR [rbp - 152]
	mov QWORD PTR [r10], r12
	mov r10, 101
	mov QWORD PTR [rbp - 176], r10
	mov r10, 48
	mov QWORD PTR [rbp - 184], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 192], r10
	mov r10, QWORD PTR [rbp - 192]
	mov r12, QWORD PTR [rbp - 184]
	add r10, r12
	mov QWORD PTR [rbp - 192], r10
	mov r10, QWORD PTR [rbp - 192]
	mov r12, QWORD PTR [rbp - 176]
	mov QWORD PTR [r10], r12
	mov r10, 32
	mov QWORD PTR [rbp - 200], r10
	mov r10, 56
	mov QWORD PTR [rbp - 208], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 216], r10
	mov r10, QWORD PTR [rbp - 216]
	mov r12, QWORD PTR [rbp - 208]
	add r10, r12
	mov QWORD PTR [rbp - 216], r10
	mov r10, QWORD PTR [rbp - 216]
	mov r12, QWORD PTR [rbp - 200]
	mov QWORD PTR [r10], r12
	mov r10, 115
	mov QWORD PTR [rbp - 224], r10
	mov r10, 64
	mov QWORD PTR [rbp - 232], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 240], r10
	mov r10, QWORD PTR [rbp - 240]
	mov r12, QWORD PTR [rbp - 232]
	add r10, r12
	mov QWORD PTR [rbp - 240], r10
	mov r10, QWORD PTR [rbp - 240]
	mov r12, QWORD PTR [rbp - 224]
	mov QWORD PTR [r10], r12
	mov r10, 112
	mov QWORD PTR [rbp - 248], r10
	mov r10, 72
	mov QWORD PTR [rbp - 256], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 264], r10
	mov r10, QWORD PTR [rbp - 264]
	mov r12, QWORD PTR [rbp - 256]
	add r10, r12
	mov QWORD PTR [rbp - 264], r10
	mov r10, QWORD PTR [rbp - 264]
	mov r12, QWORD PTR [rbp - 248]
	mov QWORD PTR [r10], r12
	mov r10, 101
	mov QWORD PTR [rbp - 272], r10
	mov r10, 80
	mov QWORD PTR [rbp - 280], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 288], r10
	mov r10, QWORD PTR [rbp - 288]
	mov r12, QWORD PTR [rbp - 280]
	add r10, r12
	mov QWORD PTR [rbp - 288], r10
	mov r10, QWORD PTR [rbp - 288]
	mov r12, QWORD PTR [rbp - 272]
	mov QWORD PTR [r10], r12
	mov r10, 99
	mov QWORD PTR [rbp - 296], r10
	mov r10, 88
	mov QWORD PTR [rbp - 304], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 312], r10
	mov r10, QWORD PTR [rbp - 312]
	mov r12, QWORD PTR [rbp - 304]
	add r10, r12
	mov QWORD PTR [rbp - 312], r10
	mov r10, QWORD PTR [rbp - 312]
	mov r12, QWORD PTR [rbp - 296]
	mov QWORD PTR [r10], r12
	mov r10, 105
	mov QWORD PTR [rbp - 320], r10
	mov r10, 96
	mov QWORD PTR [rbp - 328], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 336], r10
	mov r10, QWORD PTR [rbp - 336]
	mov r12, QWORD PTR [rbp - 328]
	add r10, r12
	mov QWORD PTR [rbp - 336], r10
	mov r10, QWORD PTR [rbp - 336]
	mov r12, QWORD PTR [rbp - 320]
	mov QWORD PTR [r10], r12
	mov r10, 102
	mov QWORD PTR [rbp - 344], r10
	mov r10, 104
	mov QWORD PTR [rbp - 352], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 360], r10
	mov r10, QWORD PTR [rbp - 360]
	mov r12, QWORD PTR [rbp - 352]
	add r10, r12
	mov QWORD PTR [rbp - 360], r10
	mov r10, QWORD PTR [rbp - 360]
	mov r12, QWORD PTR [rbp - 344]
	mov QWORD PTR [r10], r12
	mov r10, 121
	mov QWORD PTR [rbp - 368], r10
	mov r10, 112
	mov QWORD PTR [rbp - 376], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 384], r10
	mov r10, QWORD PTR [rbp - 384]
	mov r12, QWORD PTR [rbp - 376]
	add r10, r12
	mov QWORD PTR [rbp - 384], r10
	mov r10, QWORD PTR [rbp - 384]
	mov r12, QWORD PTR [rbp - 368]
	mov QWORD PTR [r10], r12
	mov r10, 32
	mov QWORD PTR [rbp - 392], r10
	mov r10, 120
	mov QWORD PTR [rbp - 400], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 408], r10
	mov r10, QWORD PTR [rbp - 408]
	mov r12, QWORD PTR [rbp - 400]
	add r10, r12
	mov QWORD PTR [rbp - 408], r10
	mov r10, QWORD PTR [rbp - 408]
	mov r12, QWORD PTR [rbp - 392]
	mov QWORD PTR [r10], r12
	mov r10, 116
	mov QWORD PTR [rbp - 416], r10
	mov r10, 128
	mov QWORD PTR [rbp - 424], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 432], r10
	mov r10, QWORD PTR [rbp - 432]
	mov r12, QWORD PTR [rbp - 424]
	add r10, r12
	mov QWORD PTR [rbp - 432], r10
	mov r10, QWORD PTR [rbp - 432]
	mov r12, QWORD PTR [rbp - 416]
	mov QWORD PTR [r10], r12
	mov r10, 104
	mov QWORD PTR [rbp - 440], r10
	mov r10, 136
	mov QWORD PTR [rbp - 448], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 456], r10
	mov r10, QWORD PTR [rbp - 456]
	mov r12, QWORD PTR [rbp - 448]
	add r10, r12
	mov QWORD PTR [rbp - 456], r10
	mov r10, QWORD PTR [rbp - 456]
	mov r12, QWORD PTR [rbp - 440]
	mov QWORD PTR [r10], r12
	mov r10, 101
	mov QWORD PTR [rbp - 464], r10
	mov r10, 144
	mov QWORD PTR [rbp - 472], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 480], r10
	mov r10, QWORD PTR [rbp - 480]
	mov r12, QWORD PTR [rbp - 472]
	add r10, r12
	mov QWORD PTR [rbp - 480], r10
	mov r10, QWORD PTR [rbp - 480]
	mov r12, QWORD PTR [rbp - 464]
	mov QWORD PTR [r10], r12
	mov r10, 32
	mov QWORD PTR [rbp - 488], r10
	mov r10, 152
	mov QWORD PTR [rbp - 496], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 504], r10
	mov r10, QWORD PTR [rbp - 504]
	mov r12, QWORD PTR [rbp - 496]
	add r10, r12
	mov QWORD PTR [rbp - 504], r10
	mov r10, QWORD PTR [rbp - 504]
	mov r12, QWORD PTR [rbp - 488]
	mov QWORD PTR [r10], r12
	mov r10, 105
	mov QWORD PTR [rbp - 512], r10
	mov r10, 160
	mov QWORD PTR [rbp - 520], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 528], r10
	mov r10, QWORD PTR [rbp - 528]
	mov r12, QWORD PTR [rbp - 520]
	add r10, r12
	mov QWORD PTR [rbp - 528], r10
	mov r10, QWORD PTR [rbp - 528]
	mov r12, QWORD PTR [rbp - 512]
	mov QWORD PTR [r10], r12
	mov r10, 110
	mov QWORD PTR [rbp - 536], r10
	mov r10, 168
	mov QWORD PTR [rbp - 544], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 552], r10
	mov r10, QWORD PTR [rbp - 552]
	mov r12, QWORD PTR [rbp - 544]
	add r10, r12
	mov QWORD PTR [rbp - 552], r10
	mov r10, QWORD PTR [rbp - 552]
	mov r12, QWORD PTR [rbp - 536]
	mov QWORD PTR [r10], r12
	mov r10, 112
	mov QWORD PTR [rbp - 560], r10
	mov r10, 176
	mov QWORD PTR [rbp - 568], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 576], r10
	mov r10, QWORD PTR [rbp - 576]
	mov r12, QWORD PTR [rbp - 568]
	add r10, r12
	mov QWORD PTR [rbp - 576], r10
	mov r10, QWORD PTR [rbp - 576]
	mov r12, QWORD PTR [rbp - 560]
	mov QWORD PTR [r10], r12
	mov r10, 117
	mov QWORD PTR [rbp - 584], r10
	mov r10, 184
	mov QWORD PTR [rbp - 592], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 600], r10
	mov r10, QWORD PTR [rbp - 600]
	mov r12, QWORD PTR [rbp - 592]
	add r10, r12
	mov QWORD PTR [rbp - 600], r10
	mov r10, QWORD PTR [rbp - 600]
	mov r12, QWORD PTR [rbp - 584]
	mov QWORD PTR [r10], r12
	mov r10, 116
	mov QWORD PTR [rbp - 608], r10
	mov r10, 192
	mov QWORD PTR [rbp - 616], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 624], r10
	mov r10, QWORD PTR [rbp - 624]
	mov r12, QWORD PTR [rbp - 616]
	add r10, r12
	mov QWORD PTR [rbp - 624], r10
	mov r10, QWORD PTR [rbp - 624]
	mov r12, QWORD PTR [rbp - 608]
	mov QWORD PTR [r10], r12
	mov r10, 32
	mov QWORD PTR [rbp - 632], r10
	mov r10, 200
	mov QWORD PTR [rbp - 640], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 648], r10
	mov r10, QWORD PTR [rbp - 648]
	mov r12, QWORD PTR [rbp - 640]
	add r10, r12
	mov QWORD PTR [rbp - 648], r10
	mov r10, QWORD PTR [rbp - 648]
	mov r12, QWORD PTR [rbp - 632]
	mov QWORD PTR [r10], r12
	mov r10, 115
	mov QWORD PTR [rbp - 656], r10
	mov r10, 208
	mov QWORD PTR [rbp - 664], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 672], r10
	mov r10, QWORD PTR [rbp - 672]
	mov r12, QWORD PTR [rbp - 664]
	add r10, r12
	mov QWORD PTR [rbp - 672], r10
	mov r10, QWORD PTR [rbp - 672]
	mov r12, QWORD PTR [rbp - 656]
	mov QWORD PTR [r10], r12
	mov r10, 105
	mov QWORD PTR [rbp - 680], r10
	mov r10, 216
	mov QWORD PTR [rbp - 688], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 696], r10
	mov r10, QWORD PTR [rbp - 696]
	mov r12, QWORD PTR [rbp - 688]
	add r10, r12
	mov QWORD PTR [rbp - 696], r10
	mov r10, QWORD PTR [rbp - 696]
	mov r12, QWORD PTR [rbp - 680]
	mov QWORD PTR [r10], r12
	mov r10, 122
	mov QWORD PTR [rbp - 704], r10
	mov r10, 224
	mov QWORD PTR [rbp - 712], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 720], r10
	mov r10, QWORD PTR [rbp - 720]
	mov r12, QWORD PTR [rbp - 712]
	add r10, r12
	mov QWORD PTR [rbp - 720], r10
	mov r10, QWORD PTR [rbp - 720]
	mov r12, QWORD PTR [rbp - 704]
	mov QWORD PTR [r10], r12
	mov r10, 101
	mov QWORD PTR [rbp - 728], r10
	mov r10, 232
	mov QWORD PTR [rbp - 736], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 744], r10
	mov r10, QWORD PTR [rbp - 744]
	mov r12, QWORD PTR [rbp - 736]
	add r10, r12
	mov QWORD PTR [rbp - 744], r10
	mov r10, QWORD PTR [rbp - 744]
	mov r12, QWORD PTR [rbp - 728]
	mov QWORD PTR [r10], r12
	mov r10, 8
	mov QWORD PTR [rbp - 752], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 760], r10
	mov r10, QWORD PTR [rbp - 760]
	mov r12, QWORD PTR [rbp - 752]
	add r10, r12
	mov QWORD PTR [rbp - 760], r10
	mov r12, QWORD PTR [rbp - 760]
	mov r10, r12
	mov QWORD PTR [rbp - 768], r10
	mov r12, QWORD PTR [rbp - 768]
	mov rdi, r12
	call _Iprintln_pai
	mov rsp, rbp
	pop r13
	pop r12
	pop rbp
	ret
	.size _Iusage_p, .-_Iusage_p
	.text 
	.globl _Imain_paai
	.type _Imain_paai, @function
_Imain_paai:
	push rbp
	push r12
	push r13
	mov rbp, rsp
	sub rsp, 528
	mov r10, rdi
	mov QWORD PTR [rbp - 8], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 16], r10
	mov r10, 11
	mov QWORD PTR [rbp - 24], r10
	mov r12, QWORD PTR [rbp - 24]
	mov r10, r12
	mov QWORD PTR [rbp - 32], r10
	mov r10, 2
	mov QWORD PTR [rbp - 40], r10
	mov r12, QWORD PTR [rbp - 40]
	mov r10, r12
	mov QWORD PTR [rbp - 48], r10
	mov r12, QWORD PTR [rbp - 32]
	mov r10, r12
	mov QWORD PTR [rbp - 56], r10
	mov r12, QWORD PTR [rbp - 48]
	mov rdi, r12
	mov r12, QWORD PTR [rbp - 56]
	mov rsi, r12
	call _IAck_iii
	mov r10, rax
	mov QWORD PTR [rbp - 64], r10
	mov r12, QWORD PTR [rbp - 64]
	mov r10, r12
	mov QWORD PTR [rbp - 72], r10
	mov r10, 56
	mov QWORD PTR [rbp - 80], r10
	mov r12, QWORD PTR [rbp - 80]
	mov r10, r12
	mov QWORD PTR [rbp - 88], r10
	mov r12, QWORD PTR [rbp - 88]
	mov rdi, r12
	call _xi_alloc
	mov r10, rax
	mov QWORD PTR [rbp - 64], r10
	mov r12, QWORD PTR [rbp - 64]
	mov r10, r12
	mov QWORD PTR [rbp - 96], r10
	mov r12, QWORD PTR [rbp - 96]
	mov r10, r12
	mov QWORD PTR [rbp - 104], r10
	mov r10, 6
	mov QWORD PTR [rbp - 112], r10
	mov r10, QWORD PTR [rbp - 104]
	mov r12, QWORD PTR [rbp - 112]
	mov QWORD PTR [r10], r12
	mov r10, 65
	mov QWORD PTR [rbp - 120], r10
	mov r10, 8
	mov QWORD PTR [rbp - 128], r10
	mov r12, QWORD PTR [rbp - 104]
	mov r10, r12
	mov QWORD PTR [rbp - 136], r10
	mov r10, QWORD PTR [rbp - 136]
	mov r12, QWORD PTR [rbp - 128]
	add r10, r12
	mov QWORD PTR [rbp - 136], r10
	mov r10, QWORD PTR [rbp - 136]
	mov r12, QWORD PTR [rbp - 120]
	mov QWORD PTR [r10], r12
	mov r10, 99
	mov QWORD PTR [rbp - 144], r10
	mov r10, 16
	mov QWORD PTR [rbp - 152], r10
	mov r12, QWORD PTR [rbp - 104]
	mov r10, r12
	mov QWORD PTR [rbp - 160], r10
	mov r10, QWORD PTR [rbp - 160]
	mov r12, QWORD PTR [rbp - 152]
	add r10, r12
	mov QWORD PTR [rbp - 160], r10
	mov r10, QWORD PTR [rbp - 160]
	mov r12, QWORD PTR [rbp - 144]
	mov QWORD PTR [r10], r12
	mov r10, 107
	mov QWORD PTR [rbp - 168], r10
	mov r10, 24
	mov QWORD PTR [rbp - 176], r10
	mov r12, QWORD PTR [rbp - 104]
	mov r10, r12
	mov QWORD PTR [rbp - 184], r10
	mov r10, QWORD PTR [rbp - 184]
	mov r12, QWORD PTR [rbp - 176]
	add r10, r12
	mov QWORD PTR [rbp - 184], r10
	mov r10, QWORD PTR [rbp - 184]
	mov r12, QWORD PTR [rbp - 168]
	mov QWORD PTR [r10], r12
	mov r10, 40
	mov QWORD PTR [rbp - 192], r10
	mov r10, 32
	mov QWORD PTR [rbp - 200], r10
	mov r12, QWORD PTR [rbp - 104]
	mov r10, r12
	mov QWORD PTR [rbp - 208], r10
	mov r10, QWORD PTR [rbp - 208]
	mov r12, QWORD PTR [rbp - 200]
	add r10, r12
	mov QWORD PTR [rbp - 208], r10
	mov r10, QWORD PTR [rbp - 208]
	mov r12, QWORD PTR [rbp - 192]
	mov QWORD PTR [r10], r12
	mov r10, 50
	mov QWORD PTR [rbp - 216], r10
	mov r10, 40
	mov QWORD PTR [rbp - 224], r10
	mov r12, QWORD PTR [rbp - 104]
	mov r10, r12
	mov QWORD PTR [rbp - 232], r10
	mov r10, QWORD PTR [rbp - 232]
	mov r12, QWORD PTR [rbp - 224]
	add r10, r12
	mov QWORD PTR [rbp - 232], r10
	mov r10, QWORD PTR [rbp - 232]
	mov r12, QWORD PTR [rbp - 216]
	mov QWORD PTR [r10], r12
	mov r10, 44
	mov QWORD PTR [rbp - 240], r10
	mov r10, 48
	mov QWORD PTR [rbp - 248], r10
	mov r12, QWORD PTR [rbp - 104]
	mov r10, r12
	mov QWORD PTR [rbp - 256], r10
	mov r10, QWORD PTR [rbp - 256]
	mov r12, QWORD PTR [rbp - 248]
	add r10, r12
	mov QWORD PTR [rbp - 256], r10
	mov r10, QWORD PTR [rbp - 256]
	mov r12, QWORD PTR [rbp - 240]
	mov QWORD PTR [r10], r12
	mov r10, 8
	mov QWORD PTR [rbp - 264], r10
	mov r12, QWORD PTR [rbp - 104]
	mov r10, r12
	mov QWORD PTR [rbp - 272], r10
	mov r10, QWORD PTR [rbp - 272]
	mov r12, QWORD PTR [rbp - 264]
	add r10, r12
	mov QWORD PTR [rbp - 272], r10
	mov r12, QWORD PTR [rbp - 272]
	mov r10, r12
	mov QWORD PTR [rbp - 280], r10
	mov r12, QWORD PTR [rbp - 280]
	mov rdi, r12
	call _Iprint_pai
	mov r12, QWORD PTR [rbp - 32]
	mov r10, r12
	mov QWORD PTR [rbp - 288], r10
	mov r12, QWORD PTR [rbp - 288]
	mov rdi, r12
	call _IunparseInt_aii
	mov r10, rax
	mov QWORD PTR [rbp - 64], r10
	mov r12, QWORD PTR [rbp - 64]
	mov r10, r12
	mov QWORD PTR [rbp - 296], r10
	mov r12, QWORD PTR [rbp - 296]
	mov r10, r12
	mov QWORD PTR [rbp - 304], r10
	mov r12, QWORD PTR [rbp - 304]
	mov rdi, r12
	call _Iprint_pai
	mov r10, 32
	mov QWORD PTR [rbp - 312], r10
	mov r12, QWORD PTR [rbp - 312]
	mov r10, r12
	mov QWORD PTR [rbp - 320], r10
	mov r12, QWORD PTR [rbp - 320]
	mov rdi, r12
	call _xi_alloc
	mov r10, rax
	mov QWORD PTR [rbp - 64], r10
	mov r12, QWORD PTR [rbp - 64]
	mov r10, r12
	mov QWORD PTR [rbp - 328], r10
	mov r12, QWORD PTR [rbp - 328]
	mov r10, r12
	mov QWORD PTR [rbp - 336], r10
	mov r10, 3
	mov QWORD PTR [rbp - 344], r10
	mov r10, QWORD PTR [rbp - 336]
	mov r12, QWORD PTR [rbp - 344]
	mov QWORD PTR [r10], r12
	mov r10, 41
	mov QWORD PTR [rbp - 352], r10
	mov r10, 8
	mov QWORD PTR [rbp - 360], r10
	mov r12, QWORD PTR [rbp - 336]
	mov r10, r12
	mov QWORD PTR [rbp - 368], r10
	mov r10, QWORD PTR [rbp - 368]
	mov r12, QWORD PTR [rbp - 360]
	add r10, r12
	mov QWORD PTR [rbp - 368], r10
	mov r10, QWORD PTR [rbp - 368]
	mov r12, QWORD PTR [rbp - 352]
	mov QWORD PTR [r10], r12
	mov r10, 58
	mov QWORD PTR [rbp - 376], r10
	mov r10, 16
	mov QWORD PTR [rbp - 384], r10
	mov r12, QWORD PTR [rbp - 336]
	mov r10, r12
	mov QWORD PTR [rbp - 392], r10
	mov r10, QWORD PTR [rbp - 392]
	mov r12, QWORD PTR [rbp - 384]
	add r10, r12
	mov QWORD PTR [rbp - 392], r10
	mov r10, QWORD PTR [rbp - 392]
	mov r12, QWORD PTR [rbp - 376]
	mov QWORD PTR [r10], r12
	mov r10, 32
	mov QWORD PTR [rbp - 400], r10
	mov r10, 24
	mov QWORD PTR [rbp - 408], r10
	mov r12, QWORD PTR [rbp - 336]
	mov r10, r12
	mov QWORD PTR [rbp - 416], r10
	mov r10, QWORD PTR [rbp - 416]
	mov r12, QWORD PTR [rbp - 408]
	add r10, r12
	mov QWORD PTR [rbp - 416], r10
	mov r10, QWORD PTR [rbp - 416]
	mov r12, QWORD PTR [rbp - 400]
	mov QWORD PTR [r10], r12
	mov r10, 8
	mov QWORD PTR [rbp - 424], r10
	mov r12, QWORD PTR [rbp - 336]
	mov r10, r12
	mov QWORD PTR [rbp - 432], r10
	mov r10, QWORD PTR [rbp - 432]
	mov r12, QWORD PTR [rbp - 424]
	add r10, r12
	mov QWORD PTR [rbp - 432], r10
	mov r12, QWORD PTR [rbp - 432]
	mov r10, r12
	mov QWORD PTR [rbp - 440], r10
	mov r12, QWORD PTR [rbp - 440]
	mov rdi, r12
	call _Iprint_pai
	mov r12, QWORD PTR [rbp - 72]
	mov r10, r12
	mov QWORD PTR [rbp - 448], r10
	mov r12, QWORD PTR [rbp - 448]
	mov rdi, r12
	call _IunparseInt_aii
	mov r10, rax
	mov QWORD PTR [rbp - 64], r10
	mov r12, QWORD PTR [rbp - 64]
	mov r10, r12
	mov QWORD PTR [rbp - 456], r10
	mov r12, QWORD PTR [rbp - 456]
	mov r10, r12
	mov QWORD PTR [rbp - 464], r10
	mov r12, QWORD PTR [rbp - 464]
	mov rdi, r12
	call _Iprint_pai
	mov r10, 8
	mov QWORD PTR [rbp - 472], r10
	mov r12, QWORD PTR [rbp - 472]
	mov r10, r12
	mov QWORD PTR [rbp - 480], r10
	mov r12, QWORD PTR [rbp - 480]
	mov rdi, r12
	call _xi_alloc
	mov r10, rax
	mov QWORD PTR [rbp - 64], r10
	mov r12, QWORD PTR [rbp - 64]
	mov r10, r12
	mov QWORD PTR [rbp - 488], r10
	mov r12, QWORD PTR [rbp - 488]
	mov r10, r12
	mov QWORD PTR [rbp - 496], r10
	mov r10, 0
	mov QWORD PTR [rbp - 504], r10
	mov r10, QWORD PTR [rbp - 496]
	mov r12, QWORD PTR [rbp - 504]
	mov QWORD PTR [r10], r12
	mov r10, 8
	mov QWORD PTR [rbp - 512], r10
	mov r12, QWORD PTR [rbp - 496]
	mov r10, r12
	mov QWORD PTR [rbp - 520], r10
	mov r10, QWORD PTR [rbp - 520]
	mov r12, QWORD PTR [rbp - 512]
	add r10, r12
	mov QWORD PTR [rbp - 520], r10
	mov r12, QWORD PTR [rbp - 520]
	mov r10, r12
	mov QWORD PTR [rbp - 528], r10
	mov r12, QWORD PTR [rbp - 528]
	mov rdi, r12
	call _Iprintln_pai
	mov rsp, rbp
	pop r13
	pop r12
	pop rbp
	ret
	.size _Imain_paai, .-_Imain_paai
	.text 
	.globl _IAck_iii
	.type _IAck_iii, @function
_IAck_iii:
	push rbp
	push r12
	push r13
	mov rbp, rsp
	sub rsp, 216
	mov r10, rdi
	mov QWORD PTR [rbp - 8], r10
	mov r10, rsi
	mov QWORD PTR [rbp - 16], r10
	mov r12, QWORD PTR [rbp - 8]
	mov r10, r12
	mov QWORD PTR [rbp - 24], r10
	mov r12, QWORD PTR [rbp - 16]
	mov r10, r12
	mov QWORD PTR [rbp - 32], r10
	mov r10, 0
	mov QWORD PTR [rbp - 40], r10
	mov r10, 1
	mov QWORD PTR [rbp - 48], r10
	mov r10, QWORD PTR [rbp - 24]
	mov r12, QWORD PTR [rbp - 40]
	cmp r10, r12
	je .L42
	mov r10, 0
	mov QWORD PTR [rbp - 48], r10
.L42:
	mov r10, QWORD PTR [rbp - 48]
	cmp r10, 0
	jne ._label2
	mov r10, 0
	mov QWORD PTR [rbp - 56], r10
	mov r10, 1
	mov QWORD PTR [rbp - 64], r10
	mov r10, QWORD PTR [rbp - 32]
	mov r12, QWORD PTR [rbp - 56]
	cmp r10, r12
	je .L43
	mov r10, 0
	mov QWORD PTR [rbp - 64], r10
.L43:
	mov r10, QWORD PTR [rbp - 64]
	cmp r10, 0
	jne ._label0
	mov r10, 1
	mov QWORD PTR [rbp - 72], r10
	mov r12, QWORD PTR [rbp - 24]
	mov r10, r12
	mov QWORD PTR [rbp - 80], r10
	mov r10, QWORD PTR [rbp - 80]
	mov r12, QWORD PTR [rbp - 72]
	sub r10, r12
	mov QWORD PTR [rbp - 80], r10
	mov r12, QWORD PTR [rbp - 80]
	mov r10, r12
	mov QWORD PTR [rbp - 88], r10
	mov r12, QWORD PTR [rbp - 24]
	mov r10, r12
	mov QWORD PTR [rbp - 96], r10
	mov r10, 1
	mov QWORD PTR [rbp - 104], r10
	mov r12, QWORD PTR [rbp - 32]
	mov r10, r12
	mov QWORD PTR [rbp - 112], r10
	mov r10, QWORD PTR [rbp - 112]
	mov r12, QWORD PTR [rbp - 104]
	sub r10, r12
	mov QWORD PTR [rbp - 112], r10
	mov r12, QWORD PTR [rbp - 112]
	mov r10, r12
	mov QWORD PTR [rbp - 120], r10
	mov r12, QWORD PTR [rbp - 96]
	mov rdi, r12
	mov r12, QWORD PTR [rbp - 120]
	mov rsi, r12
	call _IAck_iii
	mov r10, rax
	mov QWORD PTR [rbp - 128], r10
	mov r12, QWORD PTR [rbp - 128]
	mov r10, r12
	mov QWORD PTR [rbp - 136], r10
	mov r12, QWORD PTR [rbp - 136]
	mov r10, r12
	mov QWORD PTR [rbp - 144], r10
	mov r12, QWORD PTR [rbp - 88]
	mov rdi, r12
	mov r12, QWORD PTR [rbp - 144]
	mov rsi, r12
	call _IAck_iii
	mov r10, rax
	mov QWORD PTR [rbp - 128], r10
	mov r12, QWORD PTR [rbp - 128]
	mov r10, r12
	mov QWORD PTR [rbp - 152], r10
	mov r12, QWORD PTR [rbp - 152]
	mov rax, r12
	mov rsp, rbp
	pop r13
	pop r12
	pop rbp
	ret
	jmp _label1
._label0:
	mov r10, 1
	mov QWORD PTR [rbp - 160], r10
	mov r12, QWORD PTR [rbp - 24]
	mov r10, r12
	mov QWORD PTR [rbp - 168], r10
	mov r10, QWORD PTR [rbp - 168]
	mov r12, QWORD PTR [rbp - 160]
	sub r10, r12
	mov QWORD PTR [rbp - 168], r10
	mov r12, QWORD PTR [rbp - 168]
	mov r10, r12
	mov QWORD PTR [rbp - 176], r10
	mov r10, 1
	mov QWORD PTR [rbp - 184], r10
	mov r12, QWORD PTR [rbp - 184]
	mov r10, r12
	mov QWORD PTR [rbp - 192], r10
	mov r12, QWORD PTR [rbp - 176]
	mov rdi, r12
	mov r12, QWORD PTR [rbp - 192]
	mov rsi, r12
	call _IAck_iii
	mov r10, rax
	mov QWORD PTR [rbp - 128], r10
	mov r12, QWORD PTR [rbp - 128]
	mov r10, r12
	mov QWORD PTR [rbp - 200], r10
	mov r12, QWORD PTR [rbp - 200]
	mov rax, r12
	mov rsp, rbp
	pop r13
	pop r12
	pop rbp
	ret
._label1:
	jmp _label3
._label2:
	mov r10, 1
	mov QWORD PTR [rbp - 208], r10
	mov r12, QWORD PTR [rbp - 32]
	mov r10, r12
	mov QWORD PTR [rbp - 216], r10
	mov r10, QWORD PTR [rbp - 216]
	mov r12, QWORD PTR [rbp - 208]
	add r10, r12
	mov QWORD PTR [rbp - 216], r10
	mov r12, QWORD PTR [rbp - 216]
	mov rax, r12
	mov rsp, rbp
	pop r13
	pop r12
	pop rbp
	ret
._label3:
	mov rsp, rbp
	pop r13
	pop r12
	pop rbp
	ret
	.size _IAck_iii, .-_IAck_iii
